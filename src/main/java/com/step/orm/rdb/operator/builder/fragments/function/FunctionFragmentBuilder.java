package com.step.orm.rdb.operator.builder.fragments.function;

import com.step.orm.core.FeatureId;
import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;

import java.util.Map;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface FunctionFragmentBuilder extends Feature {

    static FeatureId<FunctionFragmentBuilder> createFeatureId(String suffix){
        return FeatureId.of(RDBFeatureType.function.getId().concat(":").concat(suffix));
    }

    @Override
    default String getId() {
        return getType().getFeatureId(getFunction());
    }

    @Override
    default RDBFeatureType getType() {
        return RDBFeatureType.function;
    }

    String getFunction();

    SqlFragments create(String columnFullName, RDBColumnMetadata metadata, Map<String, Object> opts);

}
