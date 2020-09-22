package com.step.orm.rdb.metadata.key;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 关连类型
 */

@Getter
@AllArgsConstructor
public enum AssociationType {
    oneToOne(false),
    manyToOne(false),
    manyToMay(true),
    oneToMay(true),

    ;

    boolean toMany;
}