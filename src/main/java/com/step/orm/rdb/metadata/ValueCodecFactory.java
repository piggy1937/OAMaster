package com.step.orm.rdb.metadata;

import com.step.orm.core.FeatureId;
import com.step.orm.core.FeatureType;
import com.step.orm.core.ValueCodec;
import com.step.orm.core.meta.Feature;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ValueCodecFactory extends Feature {

    String ID_VALUE = "valueCodecFactory";

    FeatureId<ValueCodecFactory> ID = FeatureId.of(ID_VALUE);

    @Override
    default FeatureType getType() {
        return RDBFeatureType.codec;
    }

    @Override
    default String getName() {
        return "值编解码器";
    }

    @Override
    default String getId() {
        return ID_VALUE;
    }

    Optional<ValueCodec> createValueCodec(RDBColumnMetadata column);

}

