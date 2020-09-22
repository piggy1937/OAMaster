package com.step.orm.rdb.codec;

import com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import com.step.orm.core.ValueCodec;
import com.step.orm.rdb.utils.FeatureUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.*;
import java.sql.Blob;
import java.util.concurrent.TimeUnit;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 二进制大对象转换器
 */
@Slf4j
public class BlobValueCodec implements ValueCodec<Object, Object> {

    public static final BlobValueCodec INSTANCE = new BlobValueCodec();

    @Override
    @SneakyThrows
    public Object encode(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Blob) {
            return (value);
        }
        if (!(value instanceof byte[])) {

            if (value instanceof Serializable) {
                try (ByteArrayOutputStream output = new ByteArrayOutputStream();
                     ObjectOutputStream object = new ObjectOutputStream(output)) {
                    object.writeObject(value);
                    object.flush();
                    object.close();
                    value = output.toByteArray();
                }
            } else {
                throw new NotSerializableException("unsupported encode type " + value.getClass());
            }

        }
        return ( value);
    }

    @Override
    @SneakyThrows
    public Object decode(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof Blob) {
            Blob blobValue = ((Blob) data);
            try (InputStream inputStream = blobValue.getBinaryStream()) {
                //尝试转为对象
                try {
                    ObjectInputStream inputStream1 = new ObjectInputStream(inputStream);
                    return inputStream1.readObject();
                } catch (IOException e) {
                    //可能不是对象
                } catch (ClassNotFoundException e) {
                    log.warn(e.getMessage(), e);
                }
                //转为bytes
                return blobValue.getBytes(1, (int) blobValue.length());
            } catch (Exception e) {
                log.warn("blob data error", e);
            }
        } else if (FeatureUtils.r2dbcIsAlive()) {
            Mono mono = null;
            if (data instanceof io.r2dbc.spi.Blob) {
                mono = Mono.from(((io.r2dbc.spi.Blob) data).stream())
                        .map(ByteBufferBackedInputStream::new)
                        .map(input -> {
                            //尝试转为对象
                            try {
                                ObjectInputStream inputStream1 = new ObjectInputStream(input);
                                return inputStream1.readObject();
                            } catch (IOException e) {
                                //可能不是对象
                            } catch (ClassNotFoundException e) {
                                log.warn(e.getMessage(), e);
                            }
                            return input;
                        });
            }
            if (mono != null) {
                // TODO: 2019-09-25 更好的方式？
                return mono.toFuture().get(10, TimeUnit.SECONDS);
            }
        }
        return data;
    }
}
