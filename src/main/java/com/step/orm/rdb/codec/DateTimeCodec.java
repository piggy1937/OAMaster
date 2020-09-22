package com.step.orm.rdb.codec;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

import com.step.orm.core.ValueCodec;
import com.step.orm.rdb.utils.DateTimeUtils;
import com.step.orm.rdb.utils.time.DateFormatter;
import lombok.NoArgsConstructor;
import org.joda.time.format.DateTimeFormat;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 日期转换器
 */
@NoArgsConstructor
public class DateTimeCodec implements ValueCodec {

    private String format;

    private Class toType;

    public DateTimeCodec(String format, Class toType) {
        this.format = format;
        this.toType = toType;
    }

    protected Date doParse(String dateString) {
        Date smartFormat = DateFormatter.fromString(dateString);
        if (smartFormat != null) {
            return smartFormat;
        }
        return DateTimeFormat.forPattern(format).parseDateTime(dateString).toDate();
    }

    @Override
    public Object encode(Object value) {
        if (value instanceof Date) {
            return value;
        }
        if (value instanceof String) {
            if (((String) value).contains(",")) {
                return Arrays.stream(((String) value).split(","))
                        .map(this::doParse)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
            }

            return doParse(((String) value));
        }
        return value;
    }

    @Override
    @SuppressWarnings("all")
    public Object decode(Object data) {
        if (null == data) {
            return null;
        }
        if (toType.isAssignableFrom(data.getClass())) {
            return data;
        }
        if (data instanceof Number) {
            data = new Date(((Number) data).longValue());
        } else if (data instanceof Timestamp) {
            data = Date.from(((Timestamp) data).toInstant());
        } else if (data instanceof Instant) {
            data = Date.from(((Instant) data));
        } else if (data instanceof LocalDateTime) {
            LocalDateTime dateTime = ((LocalDateTime) data);
            data = Date.from(dateTime.atZone(ZoneOffset.systemDefault()).toInstant());
        }
        if (data instanceof Date) {
            if (toType == Date.class) {
                return data;
            }
            if (toType == String.class) {
                return DateTimeUtils.format(((Date) data), format);
            }
        }
        if (data instanceof Collection) {
            return ((Collection<?>) data)
                    .stream()
                    .map(this::decode)
                    .collect((Collector) (toType == String.class ? Collectors.joining(",") : Collectors.toList()));

        }
        if (data instanceof String) {
            String stringData = ((String) data);
            if (toType == Date.class) {
                if ((stringData).contains(",")) {
                    return Arrays.stream(stringData.split(","))
                            .map(this::doParse)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                }
                data = this.doParse(stringData);
            }
        }
        return data;
    }
}
