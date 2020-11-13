import React from 'react'
const Demo = React.lazy(() => import('./pages/Demo'));
const menus = [
    {
       name:'基础信息',
       icon: 'ant-design',
       code: 'maycurManager',
       authority: 'maycurManager',
       children:[{
        name: '装箱单模板',
        icon: '',
        code: 'buggetManager',
        authority: 'buggetManager',
       },
           {
               name: '物品分类',
               icon: '',
               code: 'scheduleManager',
               authority: 'scheduleManager',
           },
           {
               name: '码头字典',
               icon: '',
               code: 'orgManager',
               authority: 'orgManager',
           },
           {
            name: '港口字典',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        },
        {
            name: '船公司字典',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        },
        {
            name: '船只字典',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        },
        {
            name: '代理公司字典',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        },
        {
            name: '模板列名',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        },{
            name: '航线录入',
            icon: '',
            code: 'orgManager',
            authority: 'orgManager',
        }

       ]
    },
    {
        name: '订单管理',
        icon: 'setting',
        code: 'baseManager',
        authority: 'baseManager',
        children: [
            {
                name: '全部订单',
                icon: 'usergroup-add',
                code: 'menuManager',
                authority: 'menuManager',
            },
            {
                name: '待审核订单',
                icon: 'usergroup-add',
                code: 'roleManager',
                authority: 'roleManager'
            },
            {
                name: '已审核订单',
                icon: 'usergroup-add',
                code: 'roleTypeManager',
                authority: 'roleTypeManager'
            },{
                name: '已完成订单',
                icon: 'usergroup-add',
                code: 'roleTypeManager',
                authority: 'roleTypeManager'
            },{
                name: '未完成订单',
                icon: 'usergroup-add',
                code: 'roleTypeManager',
                authority: 'roleTypeManager'
            },
        ]
    },
    {
        name: '通过管理',
        icon: 'user',
        code: 'platformManager',
        authority: 'platformManager',
        children: [
            {
                name: '待通过订单',
                icon: 'user',
                code: 'formManager',
                authority: 'formManager',
        
            },
            {
                name: '通过中订单',
                icon: 'user',
                code: 'templateManager',
                authority: 'templateManager',

            }, {
                name: '已通过订单',
                icon: 'user',
                code: 'modelManager',
                authority: 'modelManager',

            }
        ]

    }
]
const tabs = {
    buggetManager: <Demo />,
}

export {
    menus,
    tabs
}