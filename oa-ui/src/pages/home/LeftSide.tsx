import './home.module.css'
import React, { FC, useContext, useEffect, useRef } from 'react'
import { Tree, Input } from 'antd';
import wfcategoryContext from '../../stores/wfcategory.store';
import { observer } from 'mobx-react';
import { WfCatgoryViweModel} from '../../api/wfcategory.api';
const { Search } = Input;
const loop = (data: WfCatgoryViweModel[], searchValue: string): any => {
   
    return data.map(item => {
        const index = item.name.indexOf(searchValue);
        const beforeStr = item?.name.substr(0, index);
        const afterStr = item.name.substr(index + searchValue.length);
        const title =
            index > -1 ? (
                <span>
                    {beforeStr}
                    <span className="site-tree-search-value">{searchValue}</span>
                    {afterStr}
                </span>
            ) : (
                    <span>{item.name}</span>
                );
        if (item.children) {
            return { title, key: item.name, children: loop(item.children, searchValue) };
        }
        return {
            title,
            key: item.id,
        };

    })
};
const LeftSide: FC = () => {
    const wfcatContent = useRef(useContext(wfcategoryContext));
    useEffect(() => {
        wfcatContent.current.fetchWfCatgorysAsync();
    },[])
    return (
        <div>
            <Search style={{ marginBottom: 8 }} placeholder="Search" value={wfcatContent.current.wd} onChange={(e: React.ChangeEvent<HTMLInputElement>) => {
                wfcatContent.current.doChangeWd(e.target.value as string)
            }} />
            <Tree
                //   onExpand={this.onExpand}
                //   expandedKeys={expandedKeys}
                //   autoExpandParent={autoExpandParent}
                treeData={loop(wfcatContent.current.wfCategorys, wfcatContent.current.wd)}
            />
        </div>
    )
}
export default observer(LeftSide)