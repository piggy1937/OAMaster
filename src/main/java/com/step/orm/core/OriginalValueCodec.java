package com.step.orm.core;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class OriginalValueCodec implements ValueCodec {

    public static final OriginalValueCodec INSTANCE = new OriginalValueCodec();

    @Override
    public Object encode(Object value) {
        return value;
    }

    @Override
    public Object decode(Object data) {
        return data;
    }
}
