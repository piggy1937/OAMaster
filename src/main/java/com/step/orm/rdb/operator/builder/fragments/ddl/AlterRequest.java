package com.step.orm.rdb.operator.builder.fragments.ddl;

import com.step.orm.rdb.metadata.RDBTableMetadata;
import lombok.*;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterRequest {

    private RDBTableMetadata newTable;

    private RDBTableMetadata oldTable;

    private boolean allowDrop;

    private boolean allowAlter = true;

    private boolean allowIndexAlter = true;
}
