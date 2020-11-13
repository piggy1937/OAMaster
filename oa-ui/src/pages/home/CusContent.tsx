import React, {useEffect} from 'react';
import { Tabs, Carousel, Layout} from 'antd'
import { inject, Observer} from 'mobx-react';

const TabPane = Tabs.TabPane;
interface ICusContentProps{
    panes:any,
    activeMenu:string,
    onChangeState:()=>void
}

const CusContent:React.FC=({homeStore}:any)=>{
    const {panes,activeMenu}=homeStore
   console.log('###########',homeStore)
    useEffect(() => {
        // Update the document title using the browser API
        document.title = `You clicked 1times`;
        console.log(panes)
      },[...panes]);
    return (
        <div className='content-container'>
        {
            panes.length ? (
                <Tabs
                    style={{ height: '100%' }}
                    tabBarStyle={{ background: '#f0f2f5', marginBottom: 0 }}
                    onEdit={()=>{}}
                    onChange={()=>{}}
                    activeKey={activeMenu}
                    type="editable-card"
                    hideAdd>
                    {
                        panes.map((item:any) => (<TabPane key={item.key} tab={item.name}>
                            <div className='tabpane-box' style={{height:'100%'}}>
                                {item.content}
                            </div>
                        </TabPane>))
                    }
                </Tabs>
            ) : (
                    <div className='bg-box'>
                        {/* <Carousel className='bg-size' autoplay autoplaySpeed={5000}>
                            {imgs.map(item => (
                                <div className='bg-size' key={item}>
                                    <img src={item} alt="" style={{ width: '100%', height: '100%' }} />
                                </div>
                            ))}
                        </Carousel> */}
                    </div>
                )
        }
    </div>
    );
}
export default inject('homeStore')(CusContent)