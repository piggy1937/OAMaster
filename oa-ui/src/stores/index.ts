import React from 'react';
import AuthStore from './auth.store';
import CouterStore from './counter.store';

export const storesContext = React.createContext({
	counter: CouterStore,
	auth: AuthStore
});

export const useStores = () => React.useContext(storesContext);
