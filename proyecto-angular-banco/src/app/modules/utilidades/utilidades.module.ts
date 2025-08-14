import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { UtilidadesComponent } from './utilidades.component';


const routes: Routes = [
  { path: '', component: UtilidadesComponent }
];

@NgModule({
  declarations: [
    UtilidadesComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class UtilidadesModule { }
