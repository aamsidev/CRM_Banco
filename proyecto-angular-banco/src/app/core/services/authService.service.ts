import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/log/login'; // URL del backend

  constructor(private http: HttpClient) {}

  // Recibe un único objeto con email y password
  login(credentials: { correo: string; password: string }): Observable<any> {
    return this.http.post(this.apiUrl, credentials);
  }
}
