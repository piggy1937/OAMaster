package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.metadata.RDBIndexMetadata;
import com.step.orm.rdb.metadata.RDBTableMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import static com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments.of;
/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class CommonCreateIndexSqlBuilder implements CreateIndexSqlBuilder {

    public static final CommonCreateIndexSqlBuilder INSTANCE = new CommonCreateIndexSqlBuilder();


    @Override
    public SqlRequest build(CreateIndexParameter parameter) {
        RDBIndexMetadata index = parameter.getIndex();
        RDBTableMetadata table = parameter.getTable();
        PrepareSqlFragments fragments = of()
                .addSql("create index", index.getName(), "on", table.getFullName(), "(");
        int i = 0;
        for (RDBIndexMetadata.IndexColumn column : index.getColumns()) {
            if (i++ != 0) {
                fragments.addSql(",");
            }
            fragments.addSql(table.getDialect().quote(column.getColumn()))
                    .addSql(column.getSort().name());
        }
        return fragments.addSql(")").toRequest();
    }
}
