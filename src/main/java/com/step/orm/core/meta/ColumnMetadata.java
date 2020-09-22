package com.step.orm.core.meta;


import com.step.orm.core.DefaultValue;
import com.step.orm.core.DictionaryCodec;
import com.step.orm.core.PropertyWrapper;
import com.step.orm.core.ValueCodec;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ColumnMetadata extends FeatureSupportedMetadata, ObjectMetadata, Cloneable {
    @Override
    String getName();

    @Override
    String getAlias();

    String getComment();

    Class getJavaType();

    ValueCodec getValueCodec();

    DictionaryCodec getDictionaryCodec();

    DefaultValue getDefaultValue();

    PropertyWrapper getProperty(String property);

    PropertyWrapper getProperty(String property, Object defaultValue);

    PropertyWrapper setProperty(String property, Object value);

}
