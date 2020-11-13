import './Login.css';
import React, { useContext, useEffect, useRef } from 'react';
import { Layout, notification } from 'antd';
import LoginForm from './components/LoginForm';
import { useHistory, useLocation } from 'react-router';
import { inject } from 'mobx-react'
function Login ({props,authStore}:any) {
	const auth = authStore
	const history = useRef(useHistory());
	const location = useRef(useLocation());

	const onLogin = () => {
		if (auth.isLogined) {
			history.current.push('/');
		}
	};

	useEffect(() => {
		console.log(location.current);
		auth.refreshTokenAsync().then(() => {
			onLogin();
		});
	}, []);

	const onFinish = (values: any) => {
		const { username, password, remember } = values;
		auth.loginAsync(username, password, remember)
			.then(() => {
				onLogin();
			})
			.catch((e:any) => {
				notification['error']({
					message: '登录失败',
					description: e.message
				});
			});
	};

	return (
		
			
				<div className="antd-pro-layouts-user-layout-container">
					<div className="antd-pro-pages-user-login-style-main">
						<LoginForm onFinish={onFinish} />
					</div>
				</div>
		
	
	);
};

export default inject('authStore')(Login);
