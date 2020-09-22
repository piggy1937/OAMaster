package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.core.FeatureId;
import com.step.orm.rdb.metadata.RDBTableMetadata;
import com.step.orm.rdb.operator.builder.SqlBuilder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * builder-创建数据库语句构造器
 */
public interface CreateTableSqlBuilder extends SqlBuilder<RDBTableMetadata> {
    String ID_VALUE = "createTableSqlBuilder";
    FeatureId<CreateTableSqlBuilder> ID = FeatureId.of(ID_VALUE);
    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "Create Table SQL 构造器";
    }
}
