import React, { useContext } from 'react';
import MainContent from '../../layouts/compnents/MainContent';
import { Button } from 'antd';
import { observer } from 'mobx-react';
import counterContext from '../../stores/counter.store';

const Home: React.FC = () => {
	const counter = useContext(counterContext);

	const onClick = (e: React.MouseEvent<HTMLElement, MouseEvent>) => {
		counter.inc(1);
	};

	return (
		<MainContent>
			<span>首页页面</span>
			<span>
				数量: {counter.count} === {counter.total}{' '}
			</span>
			<Button onClick={onClick}>点击</Button>
		</MainContent>
	);
};

export default observer(Home);
