import { Route } from '@angular/router';

export const appRoutes: Route[] = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/login'
    },
    {
        path: 'login',
        loadComponent: () => import('./login/login.component').then(mod => mod.LoginComponent)
    },
    {
        path: 'dashboard',
        loadComponent: () => import('./dashboard/dashboard.component').then(mod => mod.DashboardComponent)
    },
    {
        path: '**',
        redirectTo: '/login'
    },
];
