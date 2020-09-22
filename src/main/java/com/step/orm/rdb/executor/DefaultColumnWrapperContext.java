package com.step.orm.rdb.executor;

import com.step.orm.rdb.executor.wrapper.ColumnWrapperContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@AllArgsConstructor
public class DefaultColumnWrapperContext<T> implements ColumnWrapperContext<T> {

    private int columnIndex;

    private String columnLabel;

    private Object result;

    private T rowInstance;

}
