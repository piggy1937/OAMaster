package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class CommonDropIndexSqlBuilder implements DropIndexSqlBuilder {

    public static final CommonDropIndexSqlBuilder INSTANCE=new CommonDropIndexSqlBuilder();

    @Override
    public SqlRequest build(CreateIndexParameter parameter) {
        return PrepareSqlFragments.of("drop index")
                .addSql(parameter.getIndex().getName(), "on", parameter.getTable().getFullName())
                .toRequest();
    }
}
