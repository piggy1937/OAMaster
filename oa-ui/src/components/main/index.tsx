import React,{ FC } from 'react';
import { Layout, Menu } from 'antd';
const {Content, Sider } = Layout;
const MainPage:FC = ()=>{
    return (
    <div>
        <Layout>
            <Sider>left sidebar</Sider>
            <Content>main content</Content>
            <Sider>right sidebar</Sider>
        </Layout>


    </div>)
}
export default MainPage