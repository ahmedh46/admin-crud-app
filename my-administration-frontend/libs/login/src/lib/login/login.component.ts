import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TuiInputModule } from '@taiga-ui/legacy';
import { TuiBlock } from '@taiga-ui/kit';
import { TuiTable } from '@taiga-ui/addon-table';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TuiButton, TuiLoader } from '@taiga-ui/core';

import { Router } from '@angular/router';
import { UserFacade } from '@my-admin-app/user-store';

interface allUserResponse {
  userId?: number;
  firstName: string;
  middleName?: string;
  lastName?: string;
  userName: string;
  createdDate: string;
  password?: string;
}

@Component({
  selector: 'lib-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TuiBlock,
    TuiTable,
    TuiInputModule,
    TuiLoader,
    TuiButton,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private datePipe: DatePipe,
    private userFacade: UserFacade,
    private router: Router
  ) {}

  data: allUserResponse[] = [];

  columns = Object.keys({ userName: '', createdDate: '' });

  get userName(): FormControl {
    return this.loginForm.get('userName') as FormControl;
  }

  get password(): FormControl {
    return this.loginForm.get('password') as FormControl;
  }

  protected readonly loginForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
  });

  showLoader = true;

  ngOnInit() {
    this.http.get<allUserResponse[]>(`/users`).subscribe((users) => {
      this.data = users.map((user) => {
        return {
          ...user,
          createdDate: this.datePipe.transform(
            user?.createdDate,
            'mediumDate'
          ) as string,
        };
      });
      this.showLoader = false;
    });
  }

  login() {
    this.showLoader = true;
    this.http
      .post<allUserResponse>(`/users`, {
        userName: this.userName.value,
        password: this.password.value,
      })
      .subscribe((user) => {
        this.userFacade.setUserInfo({
          userName: user.userName,
          firstName: user.firstName,
        });
        this.showLoader = false;
        this.router.navigate(['../dashboard']);
      });
  }
}
