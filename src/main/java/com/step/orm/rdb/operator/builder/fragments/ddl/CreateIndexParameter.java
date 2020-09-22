package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.metadata.RDBIndexMetadata;
import com.step.orm.rdb.metadata.RDBTableMetadata;
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
@AllArgsConstructor(staticName = "of")
public class CreateIndexParameter {
    private RDBTableMetadata table;

    private RDBIndexMetadata index;
}
