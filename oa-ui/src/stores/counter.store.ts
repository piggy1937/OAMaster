import { observable, action, computed } from 'mobx';
import { createContext } from 'react';

export class CouterStore {
	@observable count = 0;

	@action
	inc(value: number) {
		this.count += value;
	}

	@computed
	get total() {
		return this.count * 10;
	}
}

export default createContext<CouterStore>(new CouterStore());
