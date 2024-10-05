import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { UserFacade } from '@my-admin-app/user-store';
import { Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TuiButton, TuiLoader } from '@taiga-ui/core';
import { TuiInputModule } from '@taiga-ui/legacy';
import { TuiTable } from '@taiga-ui/addon-table';
import { TuiBlock } from '@taiga-ui/kit';
import { ReactiveFormsModule } from '@angular/forms';

interface allProductResponse {
  productId?: number;
  name: string;
  price?: number;
  description?: string;
  createdDate: string;
  updatedBy?: string;
}

@Component({
  selector: 'lib-dashboard',
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
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit, OnDestroy {
  userName: string = '';

  firstName: string = '';

  subscription = new Subscription();

  data: allProductResponse[] = [];

  columns = Object.keys({ name: '', description: '', price: '' });

  constructor(
    private userFacade: UserFacade,
    private http: HttpClient,
    private currencyPipe: CurrencyPipe
  ) {}

  ngOnInit(): void {
    this.userFacade.getUserInfo().subscribe((userInfo) => {
      this.userName = userInfo.userName;
      this.firstName = userInfo.firstName;
    });

    this.http.get<allProductResponse[]>(`/products`).subscribe((products) => {
      this.data = products.map((product) => {
        return {
          ...product,
          price: Number(
            this.currencyPipe.transform(product.price, 'CAD', 'symbol', '1.2-2')
          ),
        };
      });
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
