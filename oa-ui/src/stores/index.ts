import React from 'react';
import AuthStore from './auth.store';
import CouterStore from './counter.store';
import WfCategoryStore from './wfcategory.store' 
import HomeStore from './home.store' 
export default {
	authStore: new AuthStore(),
	counterStore: new CouterStore(),
	wfCategoryStore:new WfCategoryStore(),
	homeStore:new HomeStore()
}
