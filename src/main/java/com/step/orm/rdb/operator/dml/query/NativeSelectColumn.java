package com.step.orm.rdb.operator.dml.query;

import com.step.orm.rdb.operator.builder.fragments.NativeSql;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@AllArgsConstructor
public class NativeSelectColumn extends SelectColumn implements NativeSql {
    private String sql;

    public static NativeSelectColumn of(String sql){
        return new NativeSelectColumn(sql);
    }

}
