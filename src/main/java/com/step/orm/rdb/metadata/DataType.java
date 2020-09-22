package com.step.orm.rdb.metadata;

import com.step.orm.rdb.utils.DataTypeUtils;

import java.sql.JDBCType;
import java.sql.SQLType;
import java.util.function.Function;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface DataType {

    String getId();

    String getName();

    SQLType getSqlType();

    Class<?> getJavaType();

    default boolean isScaleSupport() {
        return getSqlType() == JDBCType.DECIMAL ||
                getSqlType() == JDBCType.DOUBLE ||
                getSqlType() == JDBCType.NUMERIC ||
                getSqlType() == JDBCType.FLOAT;
    }

    default boolean isLengthSupport() {
        return isScaleSupport() ||
                getSqlType() == JDBCType.VARCHAR ||
                getSqlType() == JDBCType.CHAR||
                getSqlType() == JDBCType.NVARCHAR
                ;
    }

    default boolean isNumber(){
        return DataTypeUtils.typeIsNumber(this);
    }

    static DataType custom(String id, String name, SQLType sqlType, Class<?> javaType) {
        return CustomDataType.of(id, name, sqlType, javaType);
    }

    static DataType jdbc(JDBCType jdbcType, Class<?> javaType) {
        return JdbcDataType.of(jdbcType, javaType);
    }

    static DataType builder(DataType type, Function<RDBColumnMetadata, String> builder) {
        return DataTypeBuilderSupport.of(type, builder);
    }
}
