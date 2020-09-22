package com.step.orm.rdb.operator.builder;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public enum FragmentBlock {

    before,
    selectColumn,
    selectFrom,
    join,
    where,
    term,
    groupBy,
    orderBy,
    having,
    paging,
    other,
    after,
}
