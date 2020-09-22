package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.core.Conditional;
import com.step.orm.core.dsl.Query;
import com.step.orm.core.param.QueryParam;
import com.step.orm.rdb.metadata.RDBTableMetadata;
import com.step.orm.rdb.metadata.key.ForeignKeyBuilder;

import java.util.function.Consumer;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class ForeignKeyDSLBuilder {

    private RDBTableMetadata table;
    private ForeignKeyBuilder builder = ForeignKeyBuilder.builder().build();


    public ForeignKeyDSLBuilder(RDBTableMetadata table) {
        this.table = table;
        this.builder.setAutoJoin(true);
    }


    public ForeignKeyDSLBuilder name(String name) {
        builder.setName(name);
        return this;
    }

    public ForeignKeyDSLBuilder alias(String alias) {
        builder.setAlias(alias);
        return this;
    }

    public ForeignKeyDSLBuilder target(String source) {

        builder.setTarget(source);
        return this;
    }

    public ForeignKeyDSLBuilder column(String sourceColumn, String targetColumn) {
        builder.addColumn(sourceColumn,targetColumn);
        return this;
    }

    public ForeignKeyDSLBuilder autoJoin(boolean autoJoin) {
        builder.setAutoJoin(autoJoin);
        return this;
    }

    public ForeignKeyDSLBuilder toMany() {
        builder.setAutoJoin(false);
        builder.setToMany(true);
        return this;
    }

    public ForeignKeyDSLBuilder condition(Consumer<Conditional<?>> consumer) {
        Query<?, QueryParam> query = Query.of();
        consumer.accept(query);
        builder.setTerms(query.getParam().getTerms());
        return this;
    }

    public RDBTableMetadata commit() {
        table.addForeignKey(builder);
        return table;
    }

}
