package com.step.orm.rdb.operator.dml.query;

import com.step.orm.rdb.operator.ResultOperator;
import reactor.core.publisher.Flux;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface QueryResultOperator<E, R> extends ResultOperator<E, R> {
    @Override
    R sync();

    @Override
    Flux<E> reactive();
}

