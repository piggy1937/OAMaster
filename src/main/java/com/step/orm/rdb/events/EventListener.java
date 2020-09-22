package com.step.orm.rdb.events;

import com.step.orm.core.FeatureId;
import com.step.orm.core.FeatureType;
import com.step.orm.core.meta.DefaultFeatureType;
import com.step.orm.core.meta.Feature;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface EventListener extends Feature {

    String ID_VALUE = "EventListener";

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "事件监听器";
    }

    @Override
    default FeatureType getType() {
        return DefaultFeatureType.eventListener;
    }

    FeatureId<EventListener> ID = FeatureId.of(ID_VALUE);

    void onEvent(EventType type, EventContext context);

}

