import { TuiButton, TuiIcon, TuiRoot } from '@taiga-ui/core';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

import { TuiHeader } from '@taiga-ui/layout';
import { LoginComponent } from '@my-admin-app/login';
import { DashboardComponent } from '@my-admin-app/dashboard';

@Component({
  standalone: true,
  imports: [
    RouterModule,
    TuiRoot,
    TuiHeader,
    TuiButton,
    TuiIcon,
    LoginComponent,
    DashboardComponent,
  ],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor(private router: Router) {}

  title = 'my-admin-ui';

  currentYear = new Date().getFullYear();

  navigateToLogin() {
    this.router.navigateByUrl('/login');
  }
}
