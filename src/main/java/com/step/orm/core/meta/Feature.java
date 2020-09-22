package com.step.orm.core.meta;

import com.step.orm.core.FeatureId;
import com.step.orm.core.FeatureType;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface Feature<T extends FeatureId> {

    String getId();

    String getName();

    FeatureType getType();

}
