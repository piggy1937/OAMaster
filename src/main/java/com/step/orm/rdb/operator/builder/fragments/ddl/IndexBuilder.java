package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.metadata.RDBIndexMetadata;
import com.step.orm.rdb.metadata.RDBTableMetadata;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class IndexBuilder {
    private TableBuilder tableBuilder;

    public IndexBuilder(TableBuilder tableBuilder, RDBTableMetadata table) {
        this.tableBuilder = tableBuilder;
        this.table = table;
    }

    private RDBTableMetadata table;

    private RDBIndexMetadata index = new RDBIndexMetadata();

    public IndexBuilder name(String indexName) {
        index.setName(indexName);
        return this;
    }

    public IndexBuilder unique() {
        index.setUnique(true);
        return this;
    }

    public IndexBuilder column(String column) {
        return column(column, RDBIndexMetadata.IndexSort.asc);
    }

    public IndexBuilder column(String column, String sort) {
        return column(column, RDBIndexMetadata.IndexSort.valueOf(sort));
    }

    public IndexBuilder column(String column, RDBIndexMetadata.IndexSort sort) {
        index.getColumns().add(RDBIndexMetadata.IndexColumn.of(column, sort));
        return this;
    }

    public TableBuilder commit() {
        table.addIndex(index);
        return tableBuilder;
    }

}
