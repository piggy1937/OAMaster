package com.step.orm.core;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ObjectPropertyOperator {

    Optional<Object> getProperty(Object object, String name);

    void setProperty(Object object, String name, Object value);

}
