package com.step.orm.rdb.operator.builder.fragments.update;

import com.step.orm.rdb.operator.dml.FunctionColumn;
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
public class UpdateColumn extends FunctionColumn {

    private Object value;

}