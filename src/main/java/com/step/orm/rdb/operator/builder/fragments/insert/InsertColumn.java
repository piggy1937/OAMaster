package com.step.orm.rdb.operator.builder.fragments.insert;

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
public class InsertColumn extends FunctionColumn {


    public static InsertColumn of(String column){
        InsertColumn insertColumn=new InsertColumn();

        insertColumn.setColumn(column);

        return insertColumn;
    }
}