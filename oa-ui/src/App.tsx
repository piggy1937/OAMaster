import React,{ FC,useContext } from 'react';
import { observer } from 'mobx-react'
import { RouterStore, syncHistoryWithStore } from 'mobx-react-router'
import { Router, Route, Switch,RouteProps,Redirect } from 'react-router'
import { createBrowserHistory } from 'history'
import LayoutMaster from './layouts/LayoutMaster';
import authContext from './stores/auth.store'
import Login from './pages/login/Login'
import Home from './pages/home'
import './App.css';
const browserHistory = createBrowserHistory()
const routerStore = new RouterStore();
const history = syncHistoryWithStore(browserHistory, routerStore)
const PrivateRoute: React.FC<RouteProps> = observer(({ children, ...rest }) => {
const auth = useContext(authContext);

	return (
		<Route
			{...rest}
			render={({ location }) =>
				auth.isLogined ? (
					<LayoutMaster>{children}</LayoutMaster>
				) : (
					<Redirect
						to={{
							pathname: '/login',							
							state: { from: location }
						}}
					/>
				)}
		/>
	);
});


const App: React.FC = () => {
	return (
		<Router history={history}>   
			<Switch>
				<PrivateRoute exact path="/">
             		<Home/>
				</PrivateRoute>
				<PrivateRoute path="/about">
				    <div>aaa</div>
				</PrivateRoute>
				<Route path="/login">
				     <Login></Login>
				</Route>
			</Switch>
		</Router>
	);
};

export default App;

