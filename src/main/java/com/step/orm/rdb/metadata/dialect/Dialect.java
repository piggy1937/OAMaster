package com.step.orm.rdb.metadata.dialect;

import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.metadata.DataType;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.supports.mysql.MysqlDialect;
import com.step.utils.StringUtils;

import java.sql.SQLType;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 数据库方言
 *
 * @since 1.0
 */
public interface Dialect extends Feature {
    @Override
    default RDBFeatureType getType() {
        return RDBFeatureType.dialect;
    }

    void addDataTypeBuilder(String typeId, DataTypeBuilder mapper);

    String buildColumnDataType(RDBColumnMetadata columnMetaData);

    String getQuoteStart();

    String getQuoteEnd();

    String clearQuote(String string);

    boolean isColumnToUpperCase();

    Optional<SQLType> convertSqlType(Class<?> type);

    DataType convertDataType(String dataType);

    default String quote(String keyword, boolean changeCase) {
        if (keyword.startsWith(getQuoteStart()) && keyword.endsWith(getQuoteEnd())) {
            return keyword;
        }
        return getQuoteStart().concat(isColumnToUpperCase() && changeCase ? keyword.toUpperCase() : keyword).concat(getQuoteEnd());
    }

    default String quote(String keyword) {
        return quote(keyword, true);
    }

    default String buildColumnFullName(String tableName, String columnName) {
        if (columnName.contains(".")) {
            return columnName;
        }
        if (StringUtils.isNullOrEmpty(tableName)) {
            return StringUtils.concat(getQuoteStart(), isColumnToUpperCase() ? columnName.toUpperCase() : columnName, getQuoteEnd());
        }
        return StringUtils.concat(tableName, ".", getQuoteStart(), isColumnToUpperCase() ? columnName.toUpperCase() : columnName, getQuoteEnd());
    }

    Dialect MYSQL = new MysqlDialect();
//    Dialect ORACLE = new OracleDialect();
//    Dialect H2 = new H2Dialect();
//    Dialect MSSQL = new SqlServerDialect();
//    Dialect POSTGRES = new PostgresqlDialect();

}
