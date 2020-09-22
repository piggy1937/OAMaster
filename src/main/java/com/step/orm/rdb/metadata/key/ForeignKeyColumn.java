package com.step.orm.rdb.metadata.key;

import com.step.orm.rdb.metadata.RDBColumnMetadata;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ForeignKeyColumn {
    RDBColumnMetadata getTargetColumn();

    RDBColumnMetadata getSourceColumn();
}
