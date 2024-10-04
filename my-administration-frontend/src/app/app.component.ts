import { TuiButton, TuiIcon, TuiRoot } from '@taiga-ui/core';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TuiHeader } from '@taiga-ui/layout';

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
  title = 'my-administration-frontend';

  navigateToLogin() {
    this.router.navigateByUrl('/login');
  }
}
