package com.step.orm.core;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ValueCodec<E, D> extends Encoder<E>, Decoder<D> {
    E encode(Object value);

    D decode(Object data);
}
