package com.step.orm.rdb.operator.builder.fragments.term;

import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class SymbolTermFragmentBuilder extends AbstractTermFragmentBuilder {

    private String symbol;

    public SymbolTermFragmentBuilder(String termType, String name, String symbol) {
        super(termType, name);
        this.symbol = symbol;
    }

    @Override
    public SqlFragments createFragments(String columnFullName, RDBColumnMetadata column, Term term) {
        return PrepareSqlFragments.of()
                .addSql(columnFullName, symbol, "?")
                .addParameter(convertValue(column, term));
    }
}
