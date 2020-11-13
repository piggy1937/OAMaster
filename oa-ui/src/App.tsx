import React,{ FC,useContext,Suspense, lazy  } from 'react';
import { observer,inject } from 'mobx-react'
import { RouterStore, syncHistoryWithStore } from 'mobx-react-router'
import { Router, Route, Switch,RouteProps,Redirect } from 'react-router'
import Login from './pages/login/Login'
import Home from './pages/home'
import { ErrorBoundary, Loading } from "./components";
import styles from "./App.module.css";
// NotFound 组件
const NotFound = lazy(() => import("./pages/exception/index"));
export default ({ history }: any) => {
  return (   
  <div className={styles['app']}>
	  <ErrorBoundary>
                <Router history={history}>
                    <Suspense fallback={<Loading />}>
                        <Switch>
						    <Route exact path="/login" component={Login} />
                            <Route exact path="/" component={Home} />
                            <Route component={NotFound} />
                        </Switch>
                    </Suspense>
                </Router>
            </ErrorBoundary>
  </div>)
}



