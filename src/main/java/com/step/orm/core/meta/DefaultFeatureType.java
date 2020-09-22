package com.step.orm.core.meta;

import com.step.orm.core.FeatureType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

@AllArgsConstructor
@Getter
public enum DefaultFeatureType implements FeatureType {
    metadataParser("元数据解析器"),
    eventListener("事件监听器"),
    defaultValueGenerator("默认值生成器")
    ;

    private final String name;

    @Override
    public String getId() {
        return name();
    }


}
