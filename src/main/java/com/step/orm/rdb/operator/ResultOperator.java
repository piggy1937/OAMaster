package com.step.orm.rdb.operator;

import org.reactivestreams.Publisher;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ResultOperator<E, R> {

    default R block(){
        return sync();
    }

    R sync();

    Publisher<E> reactive();

}
