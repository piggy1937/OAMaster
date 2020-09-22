package com.step.orm.core;

import com.step.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class MethodReferenceConverter {

    private static final Map<Class<?>, String> cache = new ConcurrentHashMap<>();

    public static <T> String convertToColumn(MethodReferenceColumn<T> column) {
        return convertToColumn((Object) column);
    }

    public static <T> String convertToColumn(StaticMethodReferenceColumn<T> column) {
        return convertToColumn((Object) column);
    }

    public static String convertToColumn(Object column) {
        return cache.computeIfAbsent(column.getClass(), t -> {
            SerializedLambda lambda = SerializedLambda.of(column);

            String methodName = lambda.getMethodName();
            if (methodName.startsWith("get")) {
                return StringUtils.toLowerCaseFirstOne(methodName.substring(3));
            } else if (methodName.startsWith("is")) {
                return StringUtils.toLowerCaseFirstOne(methodName.substring(2));
            }
            return methodName;
        });
    }
}
