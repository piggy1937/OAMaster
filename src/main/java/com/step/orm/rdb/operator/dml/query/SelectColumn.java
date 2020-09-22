package com.step.orm.rdb.operator.dml.query;

import com.step.orm.rdb.operator.dml.FunctionColumn;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
public class SelectColumn extends FunctionColumn {

    private String alias;

    public static SelectColumn of(String name,String alias) {
        SelectColumn column = new SelectColumn();
        column.setColumn(name);
        column.setAlias(alias);
        return column;
    }
    public static SelectColumn of(String name) {
        SelectColumn column = new SelectColumn();
        column.setColumn(name);
        return column;
    }
}
