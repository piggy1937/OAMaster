
import React, { useContext } from 'react';
import MainContent from '../../layouts/compnents/MainContent';
import { Layout,Button,Tabs,Card,Table } from 'antd';
import { inject} from 'mobx-react';
import counterContext from '../../stores/counter.store';
import LeftSide from './LeftSide'
import styles from './home.module.css'; 
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

const Home: React.FC = ({counterStore,props}:any) => {
	const counter = counterStore
	const onClick = (e: React.MouseEvent<HTMLElement, MouseEvent>) => {
		counter.inc(1);
	};

	return (
	<LayoutMaster>
		<MainContent  title='批量设置'  icons={<HomeOutlined/>}
		buttons={[
			<Button key="3" size='small'>添加</Button>,
			<Button key="2" size='small'>模板导入</Button>,
			<Button key="1" size='small' type="primary">
			  批量删除
			</Button>,
		  ]}
		>
			<Layout>
			
				<Sider className={styles.padding_top_8}><LeftSide /></Sider>
				
				<Content className={styles.margin_left_6}>
					<Tabs defaultActiveKey="1" onChange={()=>null}>
						<TabPane tab="路径列表" key="1">
						<Table rowSelection={rowSelection}  columns={columns} />
						</TabPane>
						<TabPane tab="路径维护权限" key="2">
						Content of Tab Pane 2
						</TabPane>
					</Tabs>
				</Content>
			
			</Layout>
		</MainContent>
		
		</LayoutMaster>
	);
};

export default  inject('counterStore')(Home);
