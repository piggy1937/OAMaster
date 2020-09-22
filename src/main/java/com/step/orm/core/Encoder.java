package com.step.orm.core;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 编码
 */
public interface Encoder<T> {

    T encode(Object payload);
}
