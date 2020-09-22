package com.step.orm.rdb.events;

import com.step.orm.rdb.metadata.TableOrViewMetadata;
import com.step.orm.rdb.operator.DatabaseOperator;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ContextKeys {

    ContextKey<TableOrViewMetadata> table = ContextKey.of("table");

    ContextKey<?> source = ContextKey.of("source");

    ContextKey<DatabaseOperator> database = ContextKey.of("database");

    static <T> ContextKeyValue<T> source(T source) {
        return ContextKeys.<T>source().value(source);
    }

    static <T> ContextKey<T> source() {
        return (ContextKey) source;
    }

    static <T> ContextKeyValue<TableOrViewMetadata> tableMetadata(TableOrViewMetadata metadata) {
        return ContextKeyValue.of(table, metadata);
    }

}
