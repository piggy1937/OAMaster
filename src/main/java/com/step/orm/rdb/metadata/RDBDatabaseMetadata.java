package com.step.orm.rdb.metadata;

import com.step.orm.core.meta.AbstractDatabaseMetadata;
import com.step.orm.rdb.metadata.dialect.Dialect;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class RDBDatabaseMetadata extends AbstractDatabaseMetadata<RDBSchemaMetadata> {
    protected Dialect dialect;

    public RDBDatabaseMetadata(Dialect dialect) {
        this.dialect = dialect;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public Optional<TableOrViewMetadata> getTableOrView(String name) {
        return this.getObject(name, RDBSchemaMetadata::getTableOrView);
    }

    public Optional<RDBTableMetadata> getTable(String name) {
        return this.getObject(name, RDBSchemaMetadata::getTable);
    }

    public Mono<TableOrViewMetadata> getTableOrViewReactive(String name) {
        return this.getObjectReactive(name, RDBSchemaMetadata::getTableOrViewReactive);
    }

    public Mono<RDBTableMetadata> getTableReactive(String name) {
        return this.getObjectReactive(name, RDBSchemaMetadata::getTableReactive);
    }

    @Override
    public Optional<RDBSchemaMetadata> getSchema(String name) {
        return super.getSchema(getDialect().clearQuote(name));
    }

    @Override
    public void addSchema(RDBSchemaMetadata schema) {
        schema.setDatabase(this);
        super.addSchema(schema);
    }
}
