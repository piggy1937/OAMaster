import request from '../services/request.service';
import { AxiosResponse } from 'axios';

export interface ResponseViewModel<T> {
	code: number;
	result: T;
	msg: string;
}

export interface WfCatgoryViweModel {
	key:string,
	title:string,
	children: WfCatgoryViweModel[]
}
export interface DataItemViewModel{
	key:string,
	title:string
}

export function wfCatgorysAsync(): Promise<AxiosResponse<ResponseViewModel<WfCatgoryViweModel[]>>> {
	return request.get('/workflow_category/tree');
}


