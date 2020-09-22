package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.RDBTableMetadata;

import java.util.function.Consumer;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface TableBuilder {

    TableBuilder addColumn(RDBColumnMetadata column);

    TableBuilder custom(Consumer<RDBTableMetadata> consumer);

    ColumnBuilder addColumn();

    ColumnBuilder addColumn(String name);

    TableBuilder removeColumn(String name);

    TableBuilder dropColumn(String name);

    TableBuilder comment(String comment);

    TableBuilder alias(String name);

    TableBuilder allowAlter(boolean allow);

    IndexBuilder index();

    ForeignKeyDSLBuilder  foreignKey();

    TableDDLResultOperator commit();
}
