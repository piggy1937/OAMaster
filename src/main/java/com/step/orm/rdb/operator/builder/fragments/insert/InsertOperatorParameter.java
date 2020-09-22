package com.step.orm.rdb.operator.builder.fragments.insert;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class InsertOperatorParameter {

    private Set<InsertColumn> columns = new LinkedHashSet<>();

    private List<List<Object>> values = new ArrayList<>();

}
