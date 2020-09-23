import { observable, action } from 'mobx';
import { wfCatgorysAsync,WfCatgoryViweModel} from '../api/wfcategory.api';
import { createContext } from 'react';

export class WorkflowCategoryStore {
    @observable wd:string = "";//搜索字段
    @observable wfCategorys:Array<any>=[];
    @action
    doChangeWd(wd:string){
        console.log(wd);
        this.wd=wd
    }


    @action
	setWfCategorys(data: WfCatgoryViweModel[]) {
		this.wfCategorys = data;
	}

   @action
   async fetchWfCatgorysAsync(){
    const response = await wfCatgorysAsync();		
    if (response && response.data.code === 200) {
       this.setWfCategorys(response.data.result);
    }
   }
}

export const workflowCategoryStore = new WorkflowCategoryStore();
export default createContext<WorkflowCategoryStore>(workflowCategoryStore);
