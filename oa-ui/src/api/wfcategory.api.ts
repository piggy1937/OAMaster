import request from '../services/request.service';
import { AxiosResponse } from 'axios';

export interface ResponseViewModel<T> {
	code: number;
	result: T;
	msg: string;
}

export interface WfCatgoryViweModel {
	id:number,
	name:string,
	memo?:string,
	orders?:number
}

export function wfCatgorysAsync(): Promise<AxiosResponse<ResponseViewModel<WfCatgoryViweModel[]>>> {
	return request.get('/workflow_category/all');
}


