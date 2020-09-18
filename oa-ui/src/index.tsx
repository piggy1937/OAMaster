import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import * as serviceWorker from './serviceWorker';
import { Router, Route, Switch } from 'react-router'
import { createBrowserHistory } from 'history'
import { configure } from 'mobx'
import { Provider } from 'mobx-react'
import { RouterStore, syncHistoryWithStore } from 'mobx-react-router'
import App from './App';

import Hello from './hello'
import UserStore from './store/userStore'
configure({ enforceActions: true })
const browserHistory = createBrowserHistory()
const routerStore = new RouterStore();
const history = syncHistoryWithStore(browserHistory, routerStore)
const rootStore = {
  'userStore':new UserStore()
}

ReactDOM.render(
  <Provider {...rootStore}>
    
       <Router history={history}>       
          <Switch>
          <Route path='/' component={App} exact={true}>
          </Route>
          <Route path='/h' component={Hello} />
       
          </Switch>
      </Router>
  </Provider>
  , document.getElementById('root') as HTMLElement)

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
