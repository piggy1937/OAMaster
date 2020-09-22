package com.step.orm.rdb.events;

import com.step.orm.core.CastUtil;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
class DefaultEventContext extends HashMap<String, Object> implements EventContext {

    @Override
    public Object get(String key) {
        return get((Object) key);
    }

    @Override
    public <T> Optional<T> get(ContextKey<T> key) {
        return Optional.ofNullable(get(key.getKey()))
                .map(CastUtil::cast);
    }

    @Override
    public <T> EventContext set(ContextKey<T> key, T value) {
        put(key.getKey(), value);
        return this;
    }

    @Override
    public <T> EventContext set(String key, T value) {
        put(key, value);
        return this;
    }

    @Override
    public EventContext set(ContextKeyValue<?>... keyValue) {
        for (ContextKeyValue<?> contextKeyValue : keyValue) {
            put(contextKeyValue.getKey(),contextKeyValue.getValue());
        }
        return this;
    }

}