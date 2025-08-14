import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ComercialComponent } from './comercial.component';


const routes: Routes = [
  { path: '', component: ComercialComponent }
];

@NgModule({
  declarations: [
    ComercialComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class ComercialModule { }
