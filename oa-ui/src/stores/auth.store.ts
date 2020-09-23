import { observable, action } from 'mobx';
import { loginAsync, LoginViweModel, refreshTokenAsync } from '../api/auth.api';
import { createContext } from 'react';

export class AuthStore {
	@observable isLogined = false;
	@observable userInfo = {} as LoginViweModel;

	@action
	setLogin(data: LoginViweModel) {
		console.log(data)
		this.userInfo = data;
		localStorage.setItem('token', this.userInfo.token);
		this.isLogined = true;
	}

	@action
	async loginAsync(username: string, password: string, remember: boolean = true) {
		const response = await loginAsync(username, password);
		
		if (response && response.data.code === 200) {
			this.setLogin(response.data.result);
		}
	}

	@action
	async refreshTokenAsync() {
		const token = localStorage.getItem('token');
		if (token) {
			const response = await refreshTokenAsync(token);
			if (response && response.data.code === 0) {
				this.setLogin(response.data.data);
			}
		}
	}

	@action
	async logoutAsync() {
		localStorage.removeItem('token');
		this.userInfo = {} as LoginViweModel;
		this.isLogined = false;
	}
}

export const auth = new AuthStore();
export default createContext<AuthStore>(auth);
