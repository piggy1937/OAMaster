import React from 'react';
import { Layout,PageHeader } from 'antd';
import { Link } from 'react-router-dom';
interface Props {
	title:string,
	icons?: React.ReactNode
	buttons?:any
	routes?:Array<any>
}

const MainContent: React.FC<Props> = (props) => {
	const { Content } = Layout;
	const {icons,buttons,routes}=props
	return (
		<PageHeader style={{background:'#fff',paddingTop:'0px',fontSize:'15px'}}
		  title={props.title}
		  className="site-page-header"
		  backIcon={icons}
		  onBack={()=>null}
		  breadcrumb={ {routes} }
		  extra={buttons}
		>
		   <div className="content">{props.children}</div>
		</PageHeader>
	);
};

export default MainContent;
