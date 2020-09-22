package com.step.orm.rdb.codec;

import com.step.orm.core.ValueCodec;
import com.step.orm.rdb.utils.FeatureUtils;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 将字符大对象转换器
 */
public class ClobValueCodec implements ValueCodec {

    public static final ClobValueCodec INSTANCE = new ClobValueCodec();

    @Override
    @SneakyThrows
    public Object encode(Object value) {

        if (value instanceof Clob) {
            return (value);
        }
        if (value instanceof String) {
            return value;
        }

        return value.toString();
    }

    @Override
    @SneakyThrows
    public Object decode(Object data) {
        if (data instanceof Clob) {
            Clob clobData = ((Clob) data);
            data = clobData.getSubString(1, (int) clobData.length());
        } else if (FeatureUtils.r2dbcIsAlive()) {
            Mono mono = null;
            if (data instanceof io.r2dbc.spi.Clob) {
                mono = Flux.from(((io.r2dbc.spi.Clob) data).stream())
                        .collect(Collectors.joining());
            }
            if (mono != null) {
                // TODO: 2019-09-25 更好的方式？
                return mono.toFuture().get(10, TimeUnit.SECONDS);
            }
        }else if(data instanceof ByteBuffer){
            ByteBuffer byteBuffer = ((ByteBuffer) data);

            byte[] bytes = new byte[byteBuffer.remaining()];

            byteBuffer.get(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        }

        return data;
    }
}
