package com.step.orm.core.meta;

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
public enum DefaultObjectType implements ObjectType {
    database("数据库"),
    schema("schema")

    ;

    private String name;

    @Override
    public String getId() {
        return name();
    }


}
