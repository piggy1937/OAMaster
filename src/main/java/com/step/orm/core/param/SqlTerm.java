package com.step.orm.core.param;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 直接拼接sql的方式
 */
@Getter
@Setter
public class SqlTerm extends Term {

    private String sql;

    private SqlTerm() {
    }

    public static SqlTerm of(String sql, Object... parameters) {
        return new SqlTerm(sql, parameters);
    }

    public SqlTerm(String sql, Object... value) {
        this.sql = sql;
        setValue(value);
    }

    @Override
    @SneakyThrows
    public SqlTerm clone() {
        SqlTerm term = (SqlTerm) super.clone();
        term.setSql(getSql());
        return term;
    }
}
