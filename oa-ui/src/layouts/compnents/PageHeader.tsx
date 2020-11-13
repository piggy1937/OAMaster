import React, { useContext } from 'react';
import { message, Menu, Avatar } from 'antd'
import { MenuUnfoldOutlined, MenuFoldOutlined,UserOutlined,SecurityScanOutlined} from '@ant-design/icons';

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;
interface IPageHeaderProps{
    collapsed:boolean,
    onTrigger:() => void;
}
const PageHeader:React.FC<IPageHeaderProps>=(props)=>{
  const {collapsed,onTrigger}=props
  const styles = {
    headerRight: {
        display: 'flex' ,
        float: 'right',
        height: 64,
        marginRight: 50
    },
    headerItem: {
        display: 'flex',
        alignItems: 'center',
        padding: '0 20px'
    },
    avatarBox: {
        display: 'flex',
        alignItems: 'center',
    }
}
    return (
    <>
     <div style={{ background: '#fff', padding: '0 16px'}}>
                    
                    {React.createElement(collapsed ? MenuUnfoldOutlined : MenuFoldOutlined, {
						className: 'trigger',
						onClick: onTrigger
					})}
                    
                  
                    <div style={ {
                        display: 'flex' ,
                        float: 'right',
                        height: 64,
                        marginRight: 50
                    }}>
                    {/* <div style={styles.headerItem}>
                        <ColorPicker color={color} onChange={this.changeColor} /> 
                        
                    </div>
                    <div style={styles.headerItem}>
                       
                         <MyIcon type={theme === 'dark' ? 'icon-yueliang1' : 'icon-taiyang'} style={{ fontSize: 24 }} onClick={()=>{}/> 
                         <img width={24} src={require(`../../assets/images/${theme}.svg`)} alt='' onClick={this.changeTheme} /> 
                    </div> */}
                    <div style={styles.headerItem}>
                        <Menu mode="horizontal" selectable={false}>
                            <SubMenu title={<div style={styles.avatarBox}><Avatar size='small' src={require('../../assets/img/avatar.jpg')} />&nbsp;<span>admin</span></div>}>
                                <MenuItemGroup title="用户中心">
                                    <Menu.Item key={1} onClick={()=>{}}><UserOutlined />编辑个人信息</Menu.Item>
                                    <Menu.Item key={77} onClick={()=>{}}><SecurityScanOutlined />修改密码</Menu.Item>
                                    <Menu.Item key={2} onClick={()=>{}}><SecurityScanOutlined />退出登录</Menu.Item>
                                </MenuItemGroup>
                                <MenuItemGroup title="设置中心">
                                    <Menu.Item key={3} onClick={()=>{}}>切换全屏</Menu.Item>
                                    <Menu.Item key={4} onClick={()=>{}}>恢复默认主题</Menu.Item>
                                </MenuItemGroup>
                            </SubMenu>
                        </Menu>
                    </div>
                </div>
                {/* <EditInfoModal toggleVisible={this.toggleInfoVisible} visible={infoVisible} />
                <EditPasswordModal toggleVisible={this.togglePasswordVisible} visible={passwordVisible} /> */}
            </div>

    </>)
    
}


export default PageHeader