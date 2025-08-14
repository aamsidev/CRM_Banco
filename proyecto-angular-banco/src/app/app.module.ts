import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AuthInterceptor } from './core/services/auth.interceptor';


@NgModule({
  imports: [
    BrowserModule,
    AppComponent, 
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      { path: 'terceros', loadChildren: () => import('./modules/terceros/terceros.module').then(m => m.TercerosModule) },
      { path: 'utilidades', loadChildren: () => import('./modules/utilidades/utilidades.module').then(m => m.UtilidadesModule) },
      { path: 'productos', loadChildren: () => import('./modules/productos/productos.module').then(m => m.ProductosModule) },
      { path: 'inicio', loadChildren: () => import('./modules/inicio/components/inicio.module').then(m => m.InicioModule) },
      { path: 'finanzas', loadChildren: () => import('./modules/finanzas/finanzas.module').then(m => m.FinanzasModule) },
      { path: 'comercial', loadChildren: () => import('./modules/comercial/comercial.module').then(m => m.ComercialModule) }
    ])
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: []
})
export class AppModule {}

