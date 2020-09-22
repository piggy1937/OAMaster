package com.step.orm.rdb.executor;

import com.step.orm.rdb.utils.SqlUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PrepareSqlRequest implements SqlRequest {

    private String sql;

    private Object[] parameters;

    @Override
    public boolean isEmpty() {
        return sql == null || sql.isEmpty();
    }

    public String toNativeSql() {

        return SqlUtils.toNativeSql(sql, parameters);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty sql";
        }
        return toNativeSql();
    }
}