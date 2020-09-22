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
public interface CreateIndexSqlBuilder extends SqlBuilder<CreateIndexParameter> {

    String ID_VALUE = "createIndexSqlBuilder";

    FeatureId<CreateIndexSqlBuilder> ID = FeatureId.of(ID_VALUE);

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "索引SQL构造器";
    }
}

