import React from 'react';
import AuthStore from './auth.store';
import CouterStore from './counter.store';
import WfCategoryStore from './wfcategory.store' 
export default {
	authStore: new AuthStore(),
	counterStore: new CouterStore(),
	wfCategoryStore:new WfCategoryStore()
}
