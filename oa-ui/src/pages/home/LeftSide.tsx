import React, { FC, useContext, useEffect, useRef } from 'react'
import { Tree, Input } from 'antd';
import wfcategoryContext from '../../stores/wfcategory.store';
interface ItemType {
    title: string,
    key: string
    children?: any,

}
const { Search } = Input;
const loop = (data: ItemType[], searchValue: string): any => {
    return data.map(item => {
        const index = item.title.indexOf(searchValue);
        const beforeStr = item?.title.substr(0, index);
        const afterStr = item.title.substr(index + searchValue.length);
        const title =
            index > -1 ? (
                <span>
                    {beforeStr}
                    <span className="site-tree-search-value">{searchValue}</span>
                    {afterStr}
                </span>
            ) : (
                    <span>{item.title}</span>
                );
        if (item.children) {
            return { title, key: item.key, children: loop(item.children, searchValue) };
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
    })

     console.log('111111111',wfcatContent.current.wfCategorys)
    return (
        <div>
            <Search style={{ marginBottom: 8 }} placeholder="Search" onChange={(e: React.ChangeEvent<HTMLInputElement>) => {
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
export default LeftSide