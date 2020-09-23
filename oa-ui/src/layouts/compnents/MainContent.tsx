import React from 'react';
import { Layout, Breadcrumb } from 'antd';
import { Link } from 'react-router-dom';

interface Props {
	breadcrumbs?: React.ReactNode;
}

const MainContent: React.FC<Props> = (props) => {
	const { Content } = Layout;

	return (
		<Content style={{ margin: '0 16px' }}>
			<Breadcrumb style={{ margin: '16px 0' }}>
				<Breadcrumb.Item>
					<Link to="/"> 首页</Link>
				</Breadcrumb.Item>
				{props.breadcrumbs}
			</Breadcrumb>
			<div style={{ padding: 24, background: '#fff', minHeight: 720 }}>{props.children}</div>
		</Content>
	);
};

export default MainContent;
