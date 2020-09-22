package com.step.orm.rdb.metadata;

import com.step.orm.core.OriginalValueCodec;
import com.step.orm.core.ValueCodec;
import com.step.orm.rdb.codec.BlobValueCodec;
import com.step.orm.rdb.codec.ClobValueCodec;
import com.step.orm.rdb.codec.DateTimeCodec;
import com.step.orm.rdb.codec.NumberValueCodec;
import com.step.orm.rdb.utils.DataTypeUtils;
import lombok.AllArgsConstructor;

import java.sql.JDBCType;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class DefaultValueCodecFactory implements ValueCodecFactory {

    private List<Strategy> strategies = new CopyOnWriteArrayList<>();

    private ValueCodec defaultCodec = OriginalValueCodec.INSTANCE;

    public static DefaultValueCodecFactory COMMONS = new DefaultValueCodecFactory();

    static {
        COMMONS.register(column -> DataTypeUtils.typeIsNumber(column.getType()),
                column -> new NumberValueCodec(column.getJavaType()));

        COMMONS.register(column -> DataTypeUtils.typeIsDate(column.getType()),
                column -> new DateTimeCodec("yyyy-MM-dd HH:mm:ss", column.getJavaType()));

        COMMONS.register(column -> column.getSqlType() == JDBCType.CLOB, column -> ClobValueCodec.INSTANCE);
        COMMONS.register(column -> column.getSqlType() == JDBCType.BLOB, column -> BlobValueCodec.INSTANCE);

        // TODO: 2019-09-25 更多编解码器

    }

    public void register(Predicate<RDBColumnMetadata> predicate, Function<RDBColumnMetadata, ValueCodec> function) {
        strategies.add(new Strategy(predicate, function));
    }

    @Override
    public Optional<ValueCodec> createValueCodec(RDBColumnMetadata column) {
        return strategies.stream()
                .filter(strategy -> strategy.predicate.test(column))
                .map(strategy -> strategy.function.apply(column))
                .findFirst();
    }


    @AllArgsConstructor
    class Strategy {
        Predicate<RDBColumnMetadata> predicate;

        Function<RDBColumnMetadata, ValueCodec> function;
    }
}
