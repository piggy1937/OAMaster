package com.step.orm.rdb.utils;

import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.executor.NullValue;
import com.step.orm.rdb.executor.PrepareSqlRequest;
import com.step.orm.rdb.utils.time.DateFormatter;
import org.slf4j.Logger;

import java.util.Date;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class SqlUtils {

    public static String sqlParameterToString(Object[] parameters) {
        if (parameters == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Object param : parameters) {
            if (i++ != 0) {
                builder.append(",");
            }
            builder.append(param);
            if (!(param instanceof NullValue)) {
                builder.append("(");
                builder.append(param == null ? "null" : param.getClass().getSimpleName());
                builder.append(")");
            }
        }
        return builder.toString();
    }


    public static void printSql(Logger log, SqlRequest sqlRequest) {
        if (log.isDebugEnabled()) {
            if (sqlRequest.isNotEmpty()) {
                boolean hasParameter = sqlRequest.getParameters() != null && sqlRequest.getParameters().length > 0;

                log.debug("==>  {}: {}", hasParameter ? "Preparing" : "  Execute", sqlRequest.getSql());
                if (hasParameter) {
                    log.debug("==> Parameters: {}", sqlParameterToString(sqlRequest.getParameters()));
                    if (sqlRequest instanceof PrepareSqlRequest) {
                        log.debug("==>     Native: {}", ((PrepareSqlRequest) sqlRequest).toNativeSql());
                    }
                }
            }
        }
    }


    public static String toNativeSql(String sql, Object... parameters) {
        if(parameters==null){
            return sql;
        }

        String[] stringParameter = new String[parameters.length];
        int len = 0;
        for (int i = 0; i < parameters.length; i++) {
            Object parameter = parameters[i];
            if (parameter instanceof Number) {
                stringParameter[i] = parameter.toString();
            } else if (parameter instanceof Date) {
                stringParameter[i] = "'" + DateFormatter.toString(((Date) parameter), "yyyy-MM-dd HH:mm:ss") + "'";
            } else if (parameter instanceof NullValue) {
                stringParameter[i] = "null";
            } else if (parameter == null) {
                stringParameter[i] = "null";
            } else {
                stringParameter[i] = "'" + parameter + "'";
            }
            len += stringParameter.length;
        }
        StringBuilder builder = new StringBuilder(sql.length() + len + 16);

        int parameterIndex = 0;
        for (int i = 0, sqlLen = sql.length(); i < sqlLen; i++) {
            char c = sql.charAt(i);
            if (c == '?') {
                if (stringParameter.length >= parameterIndex) {
                    builder.append(stringParameter[parameterIndex++]);
                } else {
                    builder.append("null");
                }
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
