package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.core.DefaultValue;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.executor.DefaultBatchSqlRequest;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.RDBIndexMetadata;
import com.step.orm.rdb.metadata.RDBTableMetadata;
import com.step.orm.rdb.operator.builder.fragments.NativeSql;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import static com.step.orm.rdb.executor.SqlRequests.of;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class CommonCreateTableSqlBuilder implements CreateTableSqlBuilder {

    public static final CommonCreateTableSqlBuilder INSTANCE = new CommonCreateTableSqlBuilder();

    @Override
    public SqlRequest build(RDBTableMetadata table) {
        DefaultBatchSqlRequest sql = new DefaultBatchSqlRequest();

        PrepareSqlFragments createTable = PrepareSqlFragments.of();

        createTable.addSql("create table", table.getFullName(), "(");

        int index = 0;
        for (RDBColumnMetadata column : table.getColumns()) {
            if (index++ != 0) {
                createTable.addSql(",");
            }
            createTable.addSql(column.getQuoteName());
            if (column.getColumnDefinition() != null) {
                createTable.addSql(column.getColumnDefinition());
            } else {
                createTable.addSql(column.getDialect().buildColumnDataType(column));
                DefaultValue defaultValue = column.getDefaultValue();
                if (defaultValue instanceof NativeSql) {
                    createTable.addSql("default", ((NativeSql) defaultValue).getSql());
                }
                if (column.isNotNull() || column.isPrimaryKey()) {
                    createTable.addSql("not null");
                }
                if (column.isPrimaryKey()) {
                    createTable.addSql("primary key");
                }

            }
            if (column.getComment() != null) {
                sql.addBatch(of(String.format("comment on column %s is '%s'", column.getFullName(), column.getComment())));
            }
        }
        createTable.addSql(")");

        if (table.getComment() != null) {
            sql.addBatch(of(String.format("comment on table %s is '%s'", table.getFullName(), table.getComment())));
        }

        table.findFeature(CreateIndexSqlBuilder.ID)
                .ifPresent(builder -> {
                    for (RDBIndexMetadata tableIndex : table.getIndexes()) {
                        sql.addBatch(builder.build(CreateIndexParameter.of(table, tableIndex)));
                    }
                });

        sql.setSql(createTable.toRequest().getSql());

        return sql;
    }

}
