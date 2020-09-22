package com.step.orm.rdb.events;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface EventContext {

    Object get(String key);

    <T> Optional<T> get(ContextKey<T> key);

    <T> EventContext set(ContextKey<T> key, T value);

    <T> EventContext set(String key, T value);

    EventContext set(ContextKeyValue<?>... keyValue);

    static EventContext create() {
        return new DefaultEventContext();
    }
}

