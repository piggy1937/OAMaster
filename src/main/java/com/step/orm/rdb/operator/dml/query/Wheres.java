package com.step.orm.rdb.operator.dml.query;

import com.step.orm.core.param.SqlTerm;
import com.step.orm.core.param.Term;

import java.util.function.Supplier;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface Wheres {

    static Supplier<Term> sql(String sql) {
        SqlTerm term = new SqlTerm(sql);

        return () -> term;
    }

}
