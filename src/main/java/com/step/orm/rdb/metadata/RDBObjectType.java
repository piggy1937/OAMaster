package com.step.orm.rdb.metadata;

import com.step.orm.core.meta.ObjectType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@AllArgsConstructor
public enum RDBObjectType implements ObjectType {
    table("表"),
    column("列"),
    foreignKey("外键"),
    constraint("约束"),
    key("键"),
    dataType("数据类型"),
    index("索引"),
    view("视图"),
    function("函数");

    private String name;

    @Override
    public String getId() {
        return name();
    }

}
