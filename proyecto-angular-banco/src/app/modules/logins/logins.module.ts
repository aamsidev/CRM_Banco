import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginsComponent } from './logins.component';

@NgModule({
  imports: [
    CommonModule,
    LoginsComponent // 👈 standalone se importa, no se declara
  ]
})
export class LoginsModule {}
