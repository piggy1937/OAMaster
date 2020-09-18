import React, { FC } from 'react';
import { RouteComponentProps } from 'react-router';
import { Route, Switch } from 'react-router'
import App from '../App';
interface Container extends RouteComponentProps<any> { }
const Root:FC=()=>
(<div>
    <Switch>
        <Route path="/" component={App}></Route>
    </Switch>
</div>)
 
export default Root