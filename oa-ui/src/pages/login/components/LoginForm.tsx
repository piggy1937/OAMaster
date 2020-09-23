import React from 'react';
import { Form, Input, Checkbox, Button } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';

interface Props {
	onFinish: (values: any) => void;
}

const LoginForm: React.FC<Props> = (props) => {
	return (
		<Form
			id="components-form-demo-normal-login"
			name="loginForm"
			className="login-form"
			initialValues={{ remember: true }}
			onFinish={props.onFinish}
		>
			<Form.Item name="username" rules={[ { required: true, message: '请输入用户名' } ]}>
				<Input prefix={<UserOutlined />} placeholder="用户名" />
			</Form.Item>
			<Form.Item name="password" rules={[ { required: true, message: '请输入用户登录密码' } ]}>
				<Input type="password" prefix={<LockOutlined />} placeholder="用户登录密码" />
			</Form.Item>
			<Form.Item name="remember" valuePropName="checked">
				<Checkbox>自动登录</Checkbox>
			</Form.Item>
			<Form.Item>
				<Button type="primary" htmlType="submit" className="login-form-button">
					登录
				</Button>
			</Form.Item>
		</Form>
	);
};

export default LoginForm;
