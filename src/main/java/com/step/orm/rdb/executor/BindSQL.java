package com.step.orm.rdb.executor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class BindSQL {
    private SQL sql;

    private String toField;

    public BindSQL() {
    }

    public BindSQL(SQL sql) {
        this.sql = sql;
    }

    public SQL getSql() {
        return sql;
    }

    public void setSql(SQL sql) {
        this.sql = sql;
    }

    public String getToField() {
        return toField;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }
}
