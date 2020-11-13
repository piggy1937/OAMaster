import Axios from 'axios';
import globalStore from '../stores';
import { message } from 'antd';

const request = Axios.create({
	baseURL: process.env.BASE_URL,
	timeout: 5000
});

request.interceptors.request.use(
	(config) => {
		const {authStore}=globalStore
		if (authStore.isLogined) {
			config.headers.Authorization = `Bearer ${authStore.userInfo.token?.toString()}`;
		}

		return config;
	},
	(error) => {
		message.error(error.message);
	}
);

request.interceptors.response.use(
	async (response) => {
		if (response.status === 200) {
			// 处理错误提示
			if (response.data.code !== 0) {
				message.error(response.data.msg);
			}
		}

		if (response.data.code === 10000) {
			// 刷新token
			// auth.RefreshTokenAsync();

			// 上次失败重发
			const result = await request(response.config);
			return result;
		}

		return response;
	},
	(error) => {
		switch (error.response.status) {
			case 400:
				// 数据提交验证错误
				//   if (error.response.data.code === 10400) {
				//     validateErrors.setErrors(error.response.data.data);
				//   }
				break;
			case 401:
			case 403:
			default:
				message.error(error.response.data.msg);
				break;
		}
	}
);

export default request;
