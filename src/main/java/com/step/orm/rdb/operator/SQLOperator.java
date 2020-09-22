package com.step.orm.rdb.operator;

import com.step.orm.rdb.executor.SyncSqlExecutor;
import com.step.orm.rdb.executor.reactive.ReactiveSqlExecutor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SQLOperator {

    SyncSqlExecutor sync();

    ReactiveSqlExecutor reactive();

}
