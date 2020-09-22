package com.step.orm.rdb.operator.builder.fragments.update;

import com.step.orm.core.FeatureId;
import com.step.orm.rdb.operator.builder.SqlBuilder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface UpdateSqlBuilder extends SqlBuilder<UpdateOperatorParameter> {

    String ID_VALUE = "updateSqlBuilder";

    FeatureId<UpdateSqlBuilder> ID = FeatureId.of(ID_VALUE);

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "Update SQL 构造器";
    }
}
