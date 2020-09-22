package com.step.orm.rdb.operator;

import com.step.orm.rdb.mapping.defaults.record.Record;
import com.step.orm.rdb.operator.dml.QueryOperator;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface DMLOperator {

    QueryOperator query(String tableOrView);

//    UpdateOperator update(String table);
//
//    InsertOperator insert(String table);
//
//    DeleteOperator delete(String table);
//
//    UpsertOperator upsert(String table);
//
//    <K> SyncRepository<Record, K> createRepository(String tableName);
//
//    <K> ReactiveRepository<Record, K> createReactiveRepository(String tableName);

}
