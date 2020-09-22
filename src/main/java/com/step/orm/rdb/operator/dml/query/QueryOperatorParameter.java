package com.step.orm.rdb.operator.dml.query;

import com.step.orm.core.param.Term;
import com.step.orm.rdb.operator.dml.FunctionColumn;
import com.step.orm.rdb.operator.dml.FunctionTerm;
import com.step.orm.rdb.operator.dml.Join;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class QueryOperatorParameter {

    private List<SelectColumn> select = new ArrayList<>();

    private Set<String> selectExcludes = new HashSet<>();

    private String from;

    private String fromAlias;

    private List<Term> where = new ArrayList<>();

    private List<Join> joins = new ArrayList<>();

    private List<SortOrder> orderBy = new ArrayList<>();

    private List<FunctionColumn> groupBy = new ArrayList<>();

    private List<FunctionTerm> having = new ArrayList<>();

    private Integer pageIndex;

    private Integer pageSize;

    private Boolean forUpdate;

    public Optional<Join> findJoin(String targetName) {
        return Optional.ofNullable(joins)
                .flatMap(_joins -> _joins
                        .stream()
                        .filter(join -> join.equalsTargetOrAlias(targetName))
                        .findFirst());
    }

    public String getFromAlias() {
        if (fromAlias == null) {
            return from;
        }

        return fromAlias;
    }
}