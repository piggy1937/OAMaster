package com.step.orm.rdb.operator.builder.fragments.update;

import com.step.orm.core.param.Term;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class UpdateOperatorParameter {

    List<UpdateColumn> columns = new ArrayList<>();

    List<Term> where = new ArrayList<>();

}