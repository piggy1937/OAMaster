package com.step.orm.rdb.executor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class SqlRequests {

    public static SqlRequest of(String sql, Object... parameters) {
        if (sql.contains("#{")) {
            return template(sql, parameters);
        }
        return prepare(sql, parameters);
    }

    public static SqlRequest prepare(String sql, Object... parameters) {
        return PrepareSqlRequest.of(sql, parameters);
    }

    public static SqlRequest template(String template, Object parameter) {
        return SqlTemplateParser.parse(template, parameter);
    }
}
