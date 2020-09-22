package com.step.orm.rdb.metadata;

import com.step.orm.core.CastUtil;
import com.step.orm.core.meta.ObjectType;
import com.step.orm.rdb.metadata.key.ForeignKeyMetadata;
import com.step.orm.rdb.operator.builder.fragments.insert.BatchInsertSqlBuilder;
import com.step.orm.rdb.operator.builder.fragments.update.DefaultUpdateSqlBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class RDBTableMetadata extends AbstractTableOrViewMetadata implements Cloneable {

    private String comment;

    private List<RDBIndexMetadata> indexes = new ArrayList<>();

    public RDBTableMetadata(String name) {
        this();
        setName(name);
    }

    public Optional<RDBIndexMetadata> getIndex(String indexName) {
        return indexes.stream()
                .filter(index -> index.getName().equalsIgnoreCase(indexName))
                .findFirst();
    }

    public RDBTableMetadata() {
        super();
        addFeature(BatchInsertSqlBuilder.of(this));
        addFeature(DefaultUpdateSqlBuilder.of(this));
//        addFeature(DefaultDeleteSqlBuilder.of(this));
//        addFeature(DefaultSaveOrUpdateOperator.of(this));
    }

    public void addIndex(RDBIndexMetadata index) {
        Objects.requireNonNull(index.getName(), "index name can not be null");
        index.setTableName(getName());

        indexes.add(index);

    }

    @Override
    public ObjectType getObjectType() {
        return RDBObjectType.table;
    }

    @Override
    @SneakyThrows
    public RDBTableMetadata clone() {
        RDBTableMetadata clone = (RDBTableMetadata) super.clone();
        clone.setAllColumns(new ConcurrentHashMap<>());

        this.getColumns()
                .stream()
                .map(RDBColumnMetadata::clone)
                .forEach(clone::addColumn);

        clone.setFeatures(new HashMap<>(getFeatures()));

        clone.setIndexes(getIndexes()
                .stream()
                .map(RDBIndexMetadata::clone)
                .collect(Collectors.toList()));

        this.getForeignKey()
                .stream()
                .map(ForeignKeyMetadata::clone)
                .map(CastUtil::<ForeignKeyMetadata>cast)
                .forEach(clone::addForeignKey);

        return clone;
    }

    @Override
    public void merge(TableOrViewMetadata metadata) {
        super.merge(metadata);

    }
}
