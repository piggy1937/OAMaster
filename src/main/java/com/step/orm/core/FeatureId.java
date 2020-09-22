package com.step.orm.core;

import com.step.orm.core.meta.Feature;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface FeatureId <T extends Feature>{
    String getId();
    static <T extends Feature> FeatureId<T> of(String id) {
        return () -> id;//函数式接口，这个接口包含id 字段
    }
}
