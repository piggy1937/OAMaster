package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.core.FeatureId;
import com.step.orm.rdb.operator.builder.SqlBuilder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface AlterTableSqlBuilder extends SqlBuilder<AlterRequest> {

    String ID_VALUE = "alterTableSqlBuilder";

    FeatureId<AlterTableSqlBuilder> ID =FeatureId.of(ID_VALUE);

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "表结构更新SQL构造器";
    }
}
