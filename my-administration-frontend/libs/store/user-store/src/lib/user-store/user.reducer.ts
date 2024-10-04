import { createReducer, on } from '@ngrx/store';
import { UserState } from './userInfo.model';
import { setUserInfo } from './user.action';

export const featureKey = 'user';

export const initialState: UserState = {
  userInfo: {
    userName: '',
    firstName: '',
  },
};

export const userReducer = createReducer(
  initialState,
  on(setUserInfo, (state, { userInfo }) => ({
    ...state,
    userInfo,
  }))
);
