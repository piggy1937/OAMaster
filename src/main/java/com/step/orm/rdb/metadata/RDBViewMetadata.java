package com.step.orm.rdb.metadata;

import com.step.orm.core.meta.ObjectType;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class RDBViewMetadata extends AbstractTableOrViewMetadata {
    @Override
    public ObjectType getObjectType() {
        return RDBObjectType.view;
    }
}
