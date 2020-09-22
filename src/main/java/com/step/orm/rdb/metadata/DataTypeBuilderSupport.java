package com.step.orm.rdb.metadata;

import com.step.orm.rdb.metadata.dialect.DataTypeBuilder;
import lombok.AllArgsConstructor;

import java.sql.SQLType;
import java.util.function.Function;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@AllArgsConstructor(staticName = "of")
public class DataTypeBuilderSupport implements DataType, DataTypeBuilder {

    private DataType parent;

    private Function<RDBColumnMetadata, String> builder;

    @Override
    public String getId() {
        return parent.getId();
    }

    @Override
    public String getName() {
        return parent.getName();
    }

    @Override
    public SQLType getSqlType() {
        return parent.getSqlType();
    }

    @Override
    public Class<?> getJavaType() {
        return parent.getJavaType();
    }

    @Override
    public String createColumnDataType(RDBColumnMetadata columnMetaData) {
        return builder.apply(columnMetaData);
    }
}
