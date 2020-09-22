package com.step.orm.rdb.metadata;

import com.step.orm.core.DefaultValue;
import com.step.orm.rdb.operator.builder.fragments.NativeSql;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class NativeSqlDefaultValue implements DefaultValue, NativeSql {
    private String sql;

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public Object get() {
        return this;
    }
}
