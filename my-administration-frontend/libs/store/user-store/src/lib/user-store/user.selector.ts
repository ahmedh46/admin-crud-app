import {
  createFeatureSelector,
  createSelector,
  MemoizedSelector,
} from '@ngrx/store';

import { UserInfo, UserState } from './userInfo.model';
import * as fromReducer from './user.reducer';

const getStoreState = createFeatureSelector<UserState>(fromReducer.featureKey);

export const selectUserInfo: MemoizedSelector<UserState, UserInfo> =
  createSelector(getStoreState, (state: UserState) => state?.userInfo);
