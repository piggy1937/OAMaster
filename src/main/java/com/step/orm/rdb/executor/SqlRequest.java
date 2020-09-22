package com.step.orm.rdb.executor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SqlRequest {

    String getSql();

    Object[] getParameters();

    boolean isEmpty();

    default boolean isNotEmpty() {
        return !isEmpty();
    }
}
