import React, { useContext } from 'react';
import MainContent from '../../layouts/compnents/MainContent';
import { Button } from 'antd';
import { observer } from 'mobx-react';
import counterContext from '../../stores/counter.store';

import LeftSide from './LeftSide'


const Home: React.FC = () => {
	const counter = useContext(counterContext);

	const onClick = (e: React.MouseEvent<HTMLElement, MouseEvent>) => {
		counter.inc(1);
	};

	return (
		<MainContent>
			<LeftSide></LeftSide>
		</MainContent>
	);
};

export default observer(Home);
