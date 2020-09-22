package com.step.orm.rdb.events;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ContextKey<T> {
    String getKey();

    static <T> ContextKey<T> of(String key) {
        return () -> key;
    }

    default ContextKeyValue<T> value(T value) {
        return new ContextKeyValue<T>() {
            @Override
            public String getKey() {
                return ContextKey.this.getKey();
            }

            @Override
            public T getValue() {
                return value;
            }
        };
    }
}
