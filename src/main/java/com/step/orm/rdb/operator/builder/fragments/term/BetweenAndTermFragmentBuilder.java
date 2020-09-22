package com.step.orm.rdb.operator.builder.fragments.term;

import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class BetweenAndTermFragmentBuilder extends AbstractTermFragmentBuilder {

    private final String symbol;

    public BetweenAndTermFragmentBuilder(String termType, String name, boolean isNot) {
        super(termType, name);
        symbol = isNot ? "not between ? and ?" : "between ? and ?";
    }

    @Override
    public SqlFragments createFragments(String columnFullName, RDBColumnMetadata column, Term term) {
        PrepareSqlFragments fragments = PrepareSqlFragments.of();

        List<Object> val = convertList(column, term);

        List<Object> values = new ArrayList<>(2);
        if (val.isEmpty()) {
            values.add(null);
            values.add(null);
        } else if (val.size() == 1) {
            values.add(val.get(0));
            values.add(val.get(0));
        } else {
            values.add(val.get(0));
            values.add(val.get(1));
        }

        return fragments
                .addSql(columnFullName)
                .addSql(symbol)
                .addParameter(values);
    }
}
