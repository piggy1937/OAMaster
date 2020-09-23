import React, { useContext } from 'react';
import { Menu } from 'antd';
import { Link, useHistory, useLocation } from 'react-router-dom';
import { observer } from 'mobx-react';
import { UserOutlined, MessageOutlined, PoweroffOutlined } from '@ant-design/icons';
import authContext from '../../stores/auth.store';

const SideMenu: React.FC = () => {
	const auth = useContext(authContext);
	const history = useHistory();
	const location = useLocation();

	const onExit = () => {
		auth.logoutAsync().then(() => {
			history.push('/login');
		});
	};

	return (
		<Menu theme="dark" mode="inline" selectedKeys={[ location.pathname ]}>
			<Menu.Item key="/">
				<Link to="/">
					<UserOutlined />
					<span>首页 </span>
				</Link>
			</Menu.Item>
			<Menu.Item key="/about">
				<Link to="/about">
					<MessageOutlined />
					<span>关于</span>
				</Link>
			</Menu.Item>
			<Menu.Item key="exit" onClick={onExit}>
				<PoweroffOutlined />
				<span>退出</span>
			</Menu.Item>
		</Menu>
	);
};

export default observer(SideMenu);
