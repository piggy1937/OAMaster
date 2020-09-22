package com.step.orm.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CastUtil {
    @SuppressWarnings("all")
    public static  <T> T cast(Object value){
        return ((T) value);
    }
}
