package com.step.orm.rdb.executor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EmptySqlRequest implements SqlRequest {

    public static final EmptySqlRequest INSTANCE=new EmptySqlRequest();

    @Override
    public String getSql() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] getParameters() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "empty sql";
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
