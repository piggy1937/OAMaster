package com.step.orm.rdb.operator.dml.query;

import com.step.orm.rdb.operator.dml.JoinType;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface Joins {


    static JoinOperator left(String target) {
        return new JoinOperator(target, JoinType.left);
    }

    static JoinOperator inner(String target) {
        return new JoinOperator(target, JoinType.inner);
    }

    static JoinOperator right(String target) {
        return new JoinOperator(target, JoinType.right);
    }

    static JoinOperator full(String target) {
        return new JoinOperator(target, JoinType.full);
    }
}
