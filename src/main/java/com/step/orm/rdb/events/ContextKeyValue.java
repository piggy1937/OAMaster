package com.step.orm.rdb.events;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

public interface ContextKeyValue<T> {
    String getKey();

    T getValue();

    static <T> ContextKeyValue<T> of(String key, T value) {
        return new ContextKeyValue<T>() {
            @Override
            public String getKey() {
                return key;
            }

            @Override
            public T getValue() {
                return value;
            }
        };
    }

    static <T> ContextKeyValue<T> of(ContextKey<?> key, T value) {
        return of(key.getKey(), value);
    }
}

