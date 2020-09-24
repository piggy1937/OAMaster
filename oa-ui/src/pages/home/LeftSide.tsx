
import styles from './home.module.css'; 
import React, { FC, useContext, useEffect, useRef } from 'react'
import { Tree, Input } from 'antd';
import wfcategoryContext from '../../stores/wfcategory.store';
import { observer } from 'mobx-react';
import { WfCatgoryViweModel} from '../../api/wfcategory.api';
const { Search } = Input;
const loop = (data: WfCatgoryViweModel[], searchValue: string): any => {
   
    return data.map(item => {
        const index = item.title.indexOf(searchValue);
        const beforeStr = item?.title.substr(0, index);
        const afterStr = item.title.substr(index + searchValue.length);
        const title =
            index > -1 ? (
                <span>
                    {beforeStr}
                    <span className={styles.search_filter_act}>{searchValue}</span>
                    {afterStr}
                </span>
            ) : (
                    <span>{item.title}</span>
                );
        if (item.children) {
            return { title, key: item.title, children: loop(item.children, searchValue) };
        }
        return {
            title,
            key: item.key,
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
                onExpand={(expandedKeys: React.ReactText[])=>{
                    wfcatContent.current.onExpand(expandedKeys as string[])
                }}
                autoExpandParent={wfcatContent.current.autoExpandParent}
                expandedKeys={wfcatContent.current.expandedKeys}
                treeData={loop(wfcatContent.current.wfCategorys, wfcatContent.current.wd)}
            />
        </div>
    )
}
export default observer(LeftSide)