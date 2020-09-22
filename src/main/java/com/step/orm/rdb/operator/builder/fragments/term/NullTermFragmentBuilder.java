package com.step.orm.rdb.operator.builder.fragments.term;

import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class NullTermFragmentBuilder extends AbstractTermFragmentBuilder {

    private String symbol;

    public NullTermFragmentBuilder(String termType, String name, boolean isNot) {
        super(termType, name);
        symbol = isNot ? "is not" : "is";
    }

    @Override
    public PrepareSqlFragments createFragments(String columnFullName, RDBColumnMetadata column, Term term) {

        // column = ?
        return PrepareSqlFragments.of()
                .addSql(columnFullName, symbol, "null");
    }
}