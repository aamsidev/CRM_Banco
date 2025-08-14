import { Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { InicioComponent } from './modules/inicio/components/inicio.component';
import { LoginsComponent } from './modules/logins/logins.component';


export const routes: Routes = [
  // Ruta de login fuera del layout
 

  // Rutas dentro del layout
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, // redirige a dashboard
      { path: 'inicio', component: InicioComponent },
      { path: 'login', component: LoginsComponent }, 
      // aquí puedes agregar más páginas dentro del layout
    ]
  },

  // Si no encuentra la ruta, redirige a login o a dashboard
  { path: '**', redirectTo: 'login' }
]