package com.step.orm.rdb.operator;

import com.step.orm.rdb.metadata.RDBTableMetadata;
import com.step.orm.rdb.operator.builder.fragments.ddl.TableBuilder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface DDLOperator {

    TableBuilder createOrAlter(String name);

    TableBuilder createOrAlter(RDBTableMetadata newTable);

}
