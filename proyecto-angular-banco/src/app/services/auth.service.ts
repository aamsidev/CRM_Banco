import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { LoginResponse } from '../models/login-response';
import { AutenticacionFilter } from '../models/autenticacion-filter';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/login'; // Tu backend

  constructor(private http: HttpClient) {}

  login(filter: AutenticacionFilter): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.baseUrl}/login`, filter).pipe(
      tap((res) => {
        localStorage.setItem('token', res.token);
        localStorage.setItem('email', res.email);
        localStorage.setItem('roles', JSON.stringify(res.roles));
      })
    );
  }

  logout(): void {
    localStorage.clear();
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  getUserRoles(): string[] {
    const roles = localStorage.getItem('roles');
    return roles ? JSON.parse(roles) : [];
  }

  getEmail(): string | null {
    return localStorage.getItem('email');
  }
}
