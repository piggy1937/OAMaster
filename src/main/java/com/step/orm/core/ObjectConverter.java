package com.step.orm.core;

import java.util.function.Supplier;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ObjectConverter {

    <T> T convert(Object from, Class<T> to);

    <T> T convert(Object from, Supplier<T> to);

}
