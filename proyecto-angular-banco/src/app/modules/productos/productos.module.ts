import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ProductosComponent } from './productos.component';


const routes: Routes = [
  { path: '', component: ProductosComponent }
];

@NgModule({
  declarations: [
    ProductosComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class ProductosModule { }
