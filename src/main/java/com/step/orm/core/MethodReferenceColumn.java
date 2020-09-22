package com.step.orm.core;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * 使用java8的方法引用来定义列以及值,如:
 * <pre>
 *     public UserEntity queryByUserEntity(UserEntity user){
 *     //where name =? and age > ?
 *         return createQuery()
 *         .is(user::getName)
 *         .gt(user::getAge)
 *         .single();
 *     }
 * </pre>
 *
 * @param <T>
 * @see Conditional
 * @see NestConditional
 * @see StaticMethodReferenceColumn
 * @see MethodReferenceConverter
 */
public interface MethodReferenceColumn<T> extends Supplier<T>, Serializable {

    default String getColumn() {
        return MethodReferenceConverter.convertToColumn(this);
    }
}

