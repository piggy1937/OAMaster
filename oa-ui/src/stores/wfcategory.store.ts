import { observable, action } from 'mobx';
import { wfCatgorysAsync,WfCatgoryViweModel,DataItemViewModel} from '../api/wfcategory.api';

export class WorkflowCategoryStore {
    @observable wd:string = "";//搜索字段
    @observable expandedKeys:Array<string>=[]
    @observable wfCategorys:Array<WfCatgoryViweModel>=[];
    @observable dataList:Array<DataItemViewModel>=[]
    @observable autoExpandParent:boolean=false
    @action
    doChangeWd(wd:string){
        this.wd=wd
        const expandedKeys = this.dataList
        .map(item => {
          if (item.title.indexOf(wd) > -1) {
            return this.getParentKey(item.key, this.wfCategorys);
          }
          return '';
        })
        .filter((item, i, self) => item && self.indexOf(item) === i);
        console.log(expandedKeys)
        this.expandedKeys= expandedKeys
    }


    @action
	setWfCategorys(data: WfCatgoryViweModel[]) {
        this.wfCategorys = data;
        this.generateList(data)
	}

   @action
   async fetchWfCatgorysAsync(){
    const response = await wfCatgorysAsync();		
    if (response && response.data.code === 200) {
       this.setWfCategorys(response.data.result);
    }
   }
   /***
    * 生成列表
    */
    @action
    generateList(data:WfCatgoryViweModel[]):void{
    for (let i = 0; i < data.length; i++) {
      const node:WfCatgoryViweModel = data[i];
      const { key,title } = node;
      this.dataList.push({ key, title});
      if (node.children) {
         this.generateList(node.children);
      }
    }
  };
  @action
  onExpand(expandedKeys:string[]){
    this.expandedKeys=[...expandedKeys]
    this.autoExpandParent = false
  }

   /***
    * 获取父节点主键
    */
   getParentKey(key:string, tree:Array<WfCatgoryViweModel>):string{
    let parentKey;
    for (let i = 0; i < tree.length; i++) {
      const node = tree[i];
      if (node.children) {
        if (node.children.some(item => item.key === key)) {
          parentKey = node.title;
        } else if (this.getParentKey(key, node.children)) {
          parentKey = this.getParentKey(key, node.children);
        }
      }
    }
    if(parentKey===undefined){
        return ''
    }
    return parentKey;
  };


}

export default WorkflowCategoryStore;
