package com.step.orm.rdb.operator.dml;

import com.step.orm.core.param.Term;
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
public class FunctionTerm extends Term {

    private String function;

    private Map<String, String> opts;

}
