import React from 'react';
import { Layout } from 'antd';

import './LayoutMaster.css';
import SideMenu from './compnents/SideMenu';
import PageHeader from './compnents/PageHeader'
const LayoutMaster: React.FC = (props) => {
	const [ collapsed, setCollapsed ] = React.useState(false);
	const { Header, Sider, Footer } = Layout;

	const onTrigger = () => {
		setCollapsed(!collapsed);
	};

	return (
		<Layout className="components-layout-demo-custom-trigger" style={{ minHeight: '100vh' }}>
			<Sider trigger={null} collapsible collapsed={collapsed}>
				<div className="logo" />
				<SideMenu />
			</Sider>
			<Layout>
				<Header style={{ background: '#fff', padding: 0 }}>
					<PageHeader collapsed={collapsed} onTrigger={onTrigger}></PageHeader>
				</Header>
				{props.children}
				<Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
			</Layout>
		</Layout>
	);
};

export default LayoutMaster;
