package com.step.orm.rdb.executor;

import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface BatchSqlRequest extends SqlRequest {

    List<SqlRequest> getBatch();

}
