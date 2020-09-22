package com.step.orm.rdb.operator.builder;

import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.metadata.RDBFeatureType;

import static com.step.orm.rdb.metadata.RDBFeatureType.sqlBuilder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SqlBuilder <T> extends Feature {
    @Override
    default RDBFeatureType getType() {
        return sqlBuilder;
    }

    SqlRequest build(T parameter);
}
