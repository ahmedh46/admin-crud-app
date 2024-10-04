import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFacade } from '@my-admin-app/user-store';
import { Subscription } from 'rxjs';

@Component({
  selector: 'lib-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit, OnDestroy {
  userName: string = '';

  firstName: string = '';

  subscription = new Subscription();

  constructor(private userFacade: UserFacade) {}

  ngOnInit(): void {
    this.userFacade.getUserInfo().subscribe((userInfo) => {
      this.userName = userInfo.userName;
      this.firstName = userInfo.firstName;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
