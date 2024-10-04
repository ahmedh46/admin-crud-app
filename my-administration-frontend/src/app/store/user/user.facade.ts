import { select, Store } from '@ngrx/store';
import { UserInfo, UserState } from './userInfo.model';

import * as FeatureActions from './user.action';
import * as FeatureSelectors from './user.selector';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserFacade {
  constructor(private store$: Store<UserState>) {}

  setUserInfo(userInfo: UserInfo) {
    this.store$.dispatch(FeatureActions.setUserInfo({ userInfo }));
  }

  getUserInfo() {
    return this.store$.pipe(select(FeatureSelectors.selectUserInfo));
  }
}
