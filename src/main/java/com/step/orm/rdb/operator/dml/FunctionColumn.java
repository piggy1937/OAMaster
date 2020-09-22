package com.step.orm.rdb.operator.dml;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@EqualsAndHashCode
public class FunctionColumn {
    private String column;

    private String function;

    private Map<String, Object> opts;

}
