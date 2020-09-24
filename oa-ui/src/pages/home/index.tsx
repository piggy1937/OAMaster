
import React, { useContext } from 'react';
import MainContent from '../../layouts/compnents/MainContent';
import { Layout } from 'antd';
import { observer } from 'mobx-react';
import counterContext from '../../stores/counter.store';
import LeftSide from './LeftSide'
import styles from './home.module.css'; 
const {Sider,Content}=Layout
const Home: React.FC = () => {
	const counter = useContext(counterContext);

	const onClick = (e: React.MouseEvent<HTMLElement, MouseEvent>) => {
		counter.inc(1);
	};

	return (
		<MainContent>
			 <Layout>
				<Sider className={styles.error}><LeftSide/></Sider>
				<Content>main content</Content>
			</Layout>
			
		</MainContent>
	);
};

export default observer(Home);
