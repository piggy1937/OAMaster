package com.step.orm.rdb.metadata;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.SQLType;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class CustomDataType implements DataType {

    private String id;

    private String name;

    private SQLType sqlType;

    private Class<?> javaType;

}
