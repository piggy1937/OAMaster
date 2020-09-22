package com.step.orm.core.meta;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 *  元数据对象类型,如: 表,视图.
 * 请尽量使用枚举实现此接口.
 */
public interface ObjectType {
    String getId();

    String getName();
}
