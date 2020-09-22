package com.step.orm.rdb.operator.builder.fragments.function;

import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@AllArgsConstructor
public class SimpleFunctionFragmentBuilder implements FunctionFragmentBuilder {

    private String function;

    private String name;


    @Override
    public SqlFragments create(String columnFullName, RDBColumnMetadata metadata, Map<String, Object> opts) {

        if (opts != null) {
            String arg = String.valueOf(opts.get("arg"));
            if ("1".equals(arg)) {
                columnFullName = arg;
            }
        }
        return PrepareSqlFragments
                .of()
                .addSql(function.concat("(").concat(columnFullName).concat(")"));
    }


}
