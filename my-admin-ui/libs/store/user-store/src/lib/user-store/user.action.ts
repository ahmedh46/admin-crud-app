import { createAction, props } from '@ngrx/store';
import { UserInfo } from './userInfo.model';

export const setUserInfo = createAction(
  '[UserInfo] Set User Info',
  props<{ userInfo: UserInfo }>()
);
