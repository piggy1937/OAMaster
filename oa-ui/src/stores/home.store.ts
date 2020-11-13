import { observable, action } from 'mobx';
import { loginAsync, LoginViweModel, refreshTokenAsync } from '../api/auth.api';
import {tabs} from '../../src/sysconfig'
interface ITable{
    [index: number]: Element;
}
export class HomeStore {
	@observable panes:any[]=[];
	@observable activeMenu:string = '';
	@action
	addPane = (item:any) => {
		
		const panes = this.panes.slice()
		panes.push({
			name: item.title,
			key: item.code,
			content: (tabs as ITable)[item.code] || item.title
		})
		const activeMenu:any = item.code
        //如果标签页不存在就添加一个
        if (!panes.find(i => i.key === activeMenu)) {
            panes.push({
                name: item.title,
                key: item.code,
                content: (tabs as ITable)[item.code] || item.title
            })
		}
		console.log(panes)
    }
}

export default HomeStore
