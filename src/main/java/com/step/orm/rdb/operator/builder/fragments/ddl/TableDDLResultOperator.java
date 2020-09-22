package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.operator.ResultOperator;
import reactor.core.publisher.Mono;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface TableDDLResultOperator extends ResultOperator<Boolean, Boolean> {

    @Override
    Boolean sync();

    @Override
    Mono<Boolean> reactive();

}
