
import React, { useContext } from 'react';
import CusContent from './CusContent';
import { Layout,Button,Tabs,Card,Table } from 'antd';
import { inject} from 'mobx-react';

import LayoutMaster from '../../layouts/LayoutMaster'
import {
	HomeOutlined
  } from '@ant-design/icons';
const {Sider,Content}=Layout
const { TabPane } = Tabs;
const columns = [
	{
	  title: '路径名称',
	  dataIndex: 'name',
	},
	{
	  title: '对应表单',
	  dataIndex: 'age',
	},
	{
	  title: '路径类型',
	  dataIndex: 'address',
	},
	{
		title: '显示顺序',
		dataIndex: 'address'
	  }
  ];
  const rowSelection = {
	
  };

const Home: React.FC = ({homeStore,props}:any) => {
	const {panes,activeMenu} = homeStore
	return (
	    <LayoutMaster>
		 <CusContent />
		</LayoutMaster>
	);
};

export default  inject('homeStore')(Home);
