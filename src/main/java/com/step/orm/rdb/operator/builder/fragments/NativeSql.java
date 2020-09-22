package com.step.orm.rdb.operator.builder.fragments;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface NativeSql {

    Object[] EMPTY_PARAMETER = new Object[0];

    String getSql();

    default Object[] getParameters() {
        return EMPTY_PARAMETER;
    }

    static NativeSql of(String sql, Object... parameters) {
        return new NativeSql() {
            @Override
            public String getSql() {
                return sql;
            }

            @Override
            public Object[] getParameters() {
                return parameters;
            }
        };
    }
}
