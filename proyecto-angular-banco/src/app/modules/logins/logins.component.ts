import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginService, LoginRequest, LoginResponse } from '../../core/services/login.service';

@Component({
  selector: 'app-logins',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css']
})
export class LoginsComponent {
  credentials: LoginRequest = { correo: '', password: '' };
  errorMessage = '';

  constructor(private loginService: LoginService, private router: Router) {}

  onLogin() {
    this.errorMessage = '';

    this.loginService.login(this.credentials).subscribe({
      next: (res: LoginResponse) => {
        // Guardar token y datos del usuario
        localStorage.setItem('token', res.token);
        localStorage.setItem('email', res.email);
        localStorage.setItem('roles', JSON.stringify(res.roles));

        // Redirigir al dashboard
        this.router.navigate(['/inicio']);
      },
      error: () => {
        this.errorMessage = 'Usuario o contraseña incorrectos';
      }
    });
  }
}
