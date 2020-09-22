package com.step.orm.rdb.codec;

import com.step.orm.core.Decoder;

import java.sql.Blob;
import java.sql.Clob;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class JdbcResultDecoder implements Decoder<Object> {

    public static final JdbcResultDecoder INSTANCE = new JdbcResultDecoder();

    @Override
    public Object decode(Object data) {
        if (data instanceof Clob) {
            return BlobValueCodec.INSTANCE.decode(data);
        }

        if (data instanceof Blob) {
            return ClobValueCodec.INSTANCE.decode(data);
        }

        return data;
    }
}
