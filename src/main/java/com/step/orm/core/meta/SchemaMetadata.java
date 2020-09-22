package com.step.orm.core.meta;

import java.util.List;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface SchemaMetadata extends ObjectMetadata, FeatureSupportedMetadata {

    @Override
    String getName();

    DatabaseMetadata getDatabase();

    List<ObjectType> getAllObjectType();

    <T extends ObjectMetadata> List<T> getObject(ObjectType type);

    <T extends ObjectMetadata> Optional<T> getObject(ObjectType type, String name);

    <T extends ObjectMetadata> Optional<T> removeObject(ObjectType type, String name);

    void addObject(ObjectMetadata metadata);
}
