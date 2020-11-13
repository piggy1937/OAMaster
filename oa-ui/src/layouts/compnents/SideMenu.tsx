import React, { useContext } from 'react';
import { Menu } from 'antd';
import { Link, useHistory, useLocation } from 'react-router-dom';
import { inject, observer } from 'mobx-react';
import { UserOutlined, MessageOutlined, PoweroffOutlined } from '@ant-design/icons';
import { menus } from '../../sysconfig'
import styles from './SideMenu.module.scss'
interface IMenuInfo{
	name:string,
	icon: string,
	code: string,
	authority: string,
	children?:Array<IMenuInfo>
}
const SideMenu: React.FC = ({homeStore}:any) => {

	const history = useHistory();
	const location = useLocation();
   const {addPane}=homeStore
	const onExit = () => {
		
	};
	const renderMenu = (menus:IMenuInfo[]) => {
        if (Array.isArray(menus)) {
            return menus.map(item => {
                if (!item.children || !item.children.length) {
                    return (
                        <Menu.Item key={item.name || item.name}>
                             <div onClick={() =>{addPane(item)}}>{item.icon && <i className={item.icon} ></i>}<span>{item.name}</span></div> 
                        </Menu.Item>
                    )
                } else {
                    return (
                        <Menu.SubMenu key={item.name|| item.name} title={<span>{item.icon && <i className={item.icon} ></i>}<span>{item.name}</span></span>}>
                            {renderMenu(item.children)}
                        </Menu.SubMenu>
                    )
                }
            })
        }
    }

	return (
		<div>
		<Menu  mode="inline"  theme="dark" style={{ paddingTop: 16 }}>
			{renderMenu(menus)}
		</Menu>
	</div >
	);
};

export default inject('homeStore')(SideMenu);
