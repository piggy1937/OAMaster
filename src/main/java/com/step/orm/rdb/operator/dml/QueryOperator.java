package com.step.orm.rdb.operator.dml;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

import com.step.orm.core.Conditional;
import com.step.orm.core.LogicalOperation;
import com.step.orm.core.MethodReferenceColumn;
import com.step.orm.core.StaticMethodReferenceColumn;
import com.step.orm.core.param.QueryParam;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.executor.wrapper.ResultWrapper;
import com.step.orm.rdb.operator.dml.query.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * database
 * .dml()
 * .query()
 * .select(count("id","total"))
 * .from("user")
 * .where(dsl->dsl.is("name","1"))
 * .execute()
 * .reactive(map())
 * .subscribe(data->);
 */
public abstract class QueryOperator implements LogicalOperation<QueryOperator> {

    public abstract QueryOperator select(String... columns);

    public abstract QueryOperator select(Collection<String> columns);

    public abstract QueryOperator select(SelectColumn... column);

    public QueryOperator select(SelectColumnSupplier... operators) {
        for (SelectColumnSupplier operator : operators) {
            select(operator.get());
        }
        return this;
    }

    @SafeVarargs
    public final <T> QueryOperator select(MethodReferenceColumn<T>... columns) {
        return select(Arrays.stream(columns)
                .map(MethodReferenceColumn::getColumn)
                .toArray(String[]::new));
    }

    @SafeVarargs
    public final <T> QueryOperator select(StaticMethodReferenceColumn<T>... columns) {
        return select(Arrays.stream(columns)
                .map(StaticMethodReferenceColumn::getColumn)
                .toArray(String[]::new));
    }

    public abstract QueryOperator selectExcludes(Collection<String> columns);

    public QueryOperator selectExcludes(String... columns) {
        return selectExcludes(Arrays.asList(columns));
    }

    @SafeVarargs
    public final <T> QueryOperator selectExcludes(StaticMethodReferenceColumn<T>... columns) {
        return selectExcludes(Arrays.stream(columns)
                .map(StaticMethodReferenceColumn::getColumn)
                .collect(Collectors.toSet()));
    }

    public abstract QueryOperator where(Consumer<Conditional<?>> conditionalConsumer);

    public abstract QueryOperator where(Term term);

    public abstract QueryOperator setParam(QueryParam param);

    public abstract QueryOperator where(Collection<Term> term);

    public QueryOperator where(TermSupplier... condition) {
        for (TermSupplier operator : condition) {
            where(operator.get());
        }
        return this;
    }

    public abstract QueryOperator join(Join... on);

    @SafeVarargs
    public final QueryOperator join(Supplier<Join>... on) {
        for (Supplier<Join> joinOperator : on) {
            join(joinOperator.get());
        }
        return this;
    }

    public final QueryOperator leftJoin(String target, Consumer<JoinOperator> joinOperatorConsumer) {
        JoinOperator operator = Joins.left(target);
        joinOperatorConsumer.accept(operator);
        return join(operator.get());
    }

    public final QueryOperator innerJoin(String target, Consumer<JoinOperator> joinOperatorConsumer) {
        JoinOperator operator = Joins.inner(target);
        joinOperatorConsumer.accept(operator);
        return join(operator.get());
    }

    public final QueryOperator rightJoin(String target, Consumer<JoinOperator> joinOperatorConsumer) {
        JoinOperator operator = Joins.right(target);
        joinOperatorConsumer.accept(operator);
        return join(operator.get());
    }

    public final QueryOperator fullJoin(String target, Consumer<JoinOperator> joinOperatorConsumer) {
        JoinOperator operator = Joins.right(target);
        joinOperatorConsumer.accept(operator);
        return join(operator.get());
    }

    public final QueryOperator orderBy(SortOrderSupplier... operators) {
        for (Supplier<SortOrder> operator : operators) {
            orderBy(operator.get());
        }
        return this;
    }

    public abstract QueryOperator orderBy(SortOrder... operators);

    public abstract QueryOperator groupBy(Operator<?>... operators);

    public abstract QueryOperator having(Operator<?>... operators);

    public abstract QueryOperator paging(int pageIndex, int pageSize);

    public abstract QueryOperator forUpdate();

    public abstract SqlRequest getSql();

    public abstract <E, R> QueryResultOperator<E, R> fetch(ResultWrapper<E, R> wrapper);


}
