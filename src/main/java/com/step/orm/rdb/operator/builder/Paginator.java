package com.step.orm.rdb.operator.builder;

import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface Paginator extends Feature {

    @Override
    default String getId() {
        return getType().getId();
    }

    @Override
    default String getName() {
        return getType().getName();
    }

    @Override
    default RDBFeatureType getType() {
        return RDBFeatureType.paginator;
    }

    SqlFragments doPaging(SqlFragments fragments, int pageIndex, int pageSize);

}
