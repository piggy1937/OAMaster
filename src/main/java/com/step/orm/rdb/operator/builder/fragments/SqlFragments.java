package com.step.orm.rdb.operator.builder.fragments;

import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.executor.EmptySqlRequest;
import com.step.orm.rdb.executor.SqlRequests;

import java.util.Collections;
import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SqlFragments {

    boolean isEmpty();

    default boolean isNotEmpty() {
        return !isEmpty();
    }

    List<String> getSql();

    List<Object> getParameters();

    default SqlRequest toRequest() {
        if (isEmpty()) {
            return EmptySqlRequest.INSTANCE;
        }
        return SqlRequests.prepare(String.join(" ", getSql()), getParameters().toArray());
    }

    static SqlFragments single(String sql) {
        return new SqlFragments() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public List<String> getSql() {
                return Collections.singletonList(sql);
            }

            @Override
            public List<Object> getParameters() {
                return Collections.emptyList();
            }

            @Override
            public String toString() {
                return sql;
            }
        };
    }
}
