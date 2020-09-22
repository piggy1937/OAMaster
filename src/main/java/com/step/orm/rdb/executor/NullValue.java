package com.step.orm.rdb.executor;

import com.step.orm.rdb.metadata.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class NullValue {
    @Deprecated
    private Class type;

    @NonNull
    private DataType dataType;

    public static NullValue of(DataType dataType){
        return of(dataType.getJavaType(),dataType);
    }

    @Override
    public String toString() {
        return "null" + (dataType==null?"": (type != null ? "(" + dataType.getId() + ")" : ""));
    }
}

