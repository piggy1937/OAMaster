package com.step.orm.core.meta;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ObjectMetadata extends Cloneable {

    String getName();

    String getAlias();

    ObjectType getObjectType();

    default boolean equalsNameOrAlias(String nameOrAlias) {
        return nameOrAlias != null
                && (nameOrAlias.equalsIgnoreCase(getName()) || nameOrAlias.equalsIgnoreCase(getAlias())
        );
    }

    ObjectMetadata clone();
}
