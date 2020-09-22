package com.step.orm.rdb.metadata;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.SQLType;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@AllArgsConstructor(staticName = "of")
public class JdbcDataType implements DataType {

    @Getter
    private SQLType sqlType;

    @Getter
    private Class<?> javaType;

    @Override
    public String getName() {
        return sqlType.getName().toLowerCase();
    }

    @Override
    public String getId() {
        return sqlType.getName().toLowerCase();
    }


}
