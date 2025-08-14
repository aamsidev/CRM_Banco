import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FinanzasComponent } from './finanzas.component';


const routes: Routes = [
  { path: '', component: FinanzasComponent }
];

@NgModule({
  declarations: [
    FinanzasComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class FinanzasModule { }
