import React from 'react';
import AuthStore from './auth.store';
import CouterStore from './counter.store';
import WfCategoryStore from './wfcategory.store'

export const storesContext = React.createContext({
	counter: CouterStore,
	auth: AuthStore,
	wfcat:WfCategoryStore
});

export const useStores = () => React.useContext(storesContext);
