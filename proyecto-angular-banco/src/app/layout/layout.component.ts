import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-layout',
  standalone: true, // 👈 le dices a Angular que es standalone
  imports: [CommonModule, RouterOutlet], // 👈 aquí habilitas <router-outlet>
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent { }
