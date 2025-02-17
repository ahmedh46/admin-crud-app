import { NG_EVENT_PLUGINS } from '@taiga-ui/event-plugins';
import { provideAnimations } from '@angular/platform-browser/animations';
import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { appRoutes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { provideStore } from '@ngrx/store';
import { userReducer } from '@my-admin-app/user-store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { provideRouterStore, routerReducer } from '@ngrx/router-store';

export const appConfig: ApplicationConfig = {
  providers: [
    provideAnimations(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(appRoutes),
    provideHttpClient(),
    DatePipe,
    CurrencyPipe,
    provideStore({ router: routerReducer, user: userReducer }),
    provideRouterStore(),
    provideStoreDevtools(),
    NG_EVENT_PLUGINS,
  ],
};
