package com.step.orm.rdb.operator.builder;

import com.step.orm.core.FeatureId;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.operator.dml.query.QueryOperatorParameter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface QuerySqlBuilder extends SqlBuilder<QueryOperatorParameter> {

    String ID_VALUE = "querySqlBuilder";

    FeatureId<QuerySqlBuilder> ID = FeatureId.of(ID_VALUE);

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "查询SQL构造器";
    }

    @Override
    SqlRequest build(QueryOperatorParameter parameter);


}

