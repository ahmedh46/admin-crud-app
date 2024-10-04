import { Route } from '@angular/router';

export const appRoutes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/login',
  },
  {
    path: 'login',
    loadComponent: () =>
      import('@my-admin-app/login').then((mod) => mod.LoginComponent),
  },
  {
    path: 'dashboard',
    loadComponent: () =>
      import('@my-admin-app/dashboard').then((mod) => mod.DashboardComponent),
  },
  {
    path: '**',
    redirectTo: '/login',
  },
];
