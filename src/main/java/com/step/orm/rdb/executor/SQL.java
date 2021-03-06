package com.step.orm.rdb.executor;

import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SQL {
    /**
     * 获取sql语句模板
     *
     * @return sql语句模板
     */
    String getSql();

    /**
     * 获取预编译参数
     *
     * @return
     */
    Object getParams();

    /**
     * 获取关联查询的sql
     *
     * @return
     */
    List<BindSQL> getBinds();

    int size();
}
