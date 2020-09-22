package com.step.orm.rdb.operator.dml.query;

import com.step.orm.core.Conditional;
import com.step.orm.core.dsl.Query;
import com.step.orm.core.param.QueryParam;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.operator.dml.Join;
import com.step.orm.rdb.operator.dml.JoinType;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class JoinOperator implements Supplier<Join> {

    private Join join = new Join();

    public JoinOperator(String target, JoinType type) {
        join.setTarget(target);
        join.setType(type);
    }

    public final JoinOperator as(String alias) {
        join.setAlias(alias);

        return this;
    }

    public final JoinOperator on(String sql) {
        return on(Wheres.sql(sql));
    }

    public final JoinOperator on(Consumer<Conditional<?>> consumer) {
        Query<?, QueryParam> query = Query.of();
        consumer.accept(query);
        join.getTerms().addAll(query.getParam().getTerms());
        return this;
    }

    @SafeVarargs
    public final JoinOperator on(Supplier<Term>... conditions) {
        for (Supplier<Term> condition : conditions) {
            join.getTerms().add(condition.get());
        }
        return this;
    }

    @Override
    public Join get() {
        return join;
    }
}
