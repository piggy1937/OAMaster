package com.step.orm.rdb.metadata;

import com.step.orm.core.FeatureId;
import com.step.orm.core.meta.Feature;
import com.step.orm.core.meta.FeatureSupportedMetadata;
import com.step.orm.core.meta.ObjectMetadata;
import com.step.orm.core.meta.ObjectType;
import com.step.orm.rdb.events.*;
import com.step.orm.rdb.metadata.dialect.Dialect;
import com.step.orm.rdb.metadata.key.ForeignKeyBuilder;
import com.step.orm.rdb.metadata.key.ForeignKeyMetadata;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.of;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * DQL 对象元数据: 表或者视图
 */
public interface TableOrViewMetadata extends ObjectMetadata, FeatureSupportedMetadata {

    @Override
    ObjectType getObjectType();

    /**
     * 当前数据库方言
     *
     * @return 方言
     */
    Dialect getDialect();

    /**
     * @return 元数据所在schema
     */
    RDBSchemaMetadata getSchema();

    /**
     * @return 获取当前表或者视图所有列
     */
    List<RDBColumnMetadata> getColumns();

    /**
     * @return 获取所有列, 并且包含关联表对列
     */
    List<RDBColumnMetadata> findColumns();

    /**
     * 获取当前表或者视图对列
     *
     * @param name 列名或者别名
     * @return Optional
     * @see RDBColumnMetadata#getName()
     * @see RDBColumnMetadata#getAlias()
     */
    Optional<RDBColumnMetadata> getColumn(String name);

    /**
     * 查找列,可查找通过外键关联表对列或者其他表对列
     *
     * @param name 列全名或别名,比如: user.name , schema1.user.name
     * @return Optional
     */
    Optional<RDBColumnMetadata> findColumn(String name);

    /**
     * 获取全部外键
     *
     * @return 全部外键集合
     */
    List<ForeignKeyMetadata> getForeignKeys();

    /**
     * 根据关联表获取外键
     *
     * @param targetName 关联表名
     * @return Optional
     */
    Optional<ForeignKeyMetadata> getForeignKey(String targetName);

    /**
     * 添加外键元数据
     *
     * @param metadata ForeignKeyMetadata
     * @see ForeignKeyBuilder
     * @see this#addForeignKey(ForeignKeyBuilder)
     */
    void addForeignKey(ForeignKeyMetadata metadata);

    /**
     * 使用builder添加外键元数据
     *
     * @param builder Builder
     * @return 添加后的元数据
     */
    ForeignKeyMetadata addForeignKey(ForeignKeyBuilder builder);

    /**
     * 触发事件
     *
     * @param eventType 事件类型
     * @param keyValues 事件上下文键值内容
     */
    default void fireEvent(EventType eventType, ContextKeyValue<?>... keyValues) {
        fireEvent(eventType, ctx -> ctx.set(keyValues));
    }

    /**
     * 触发事件,如果存在触发器
     *
     * @param eventType       事件类型
     * @param contextConsumer 上下文消费者
     */
    default void fireEvent(EventType eventType, Consumer<EventContext> contextConsumer) {
        this.findFeature(EventListener.ID)
                .ifPresent(eventListener -> {
                    EventContext context = EventContext.create();
                    context.set(ContextKeys.table, this);
                    contextConsumer.accept(context);
                    eventListener.onEvent(eventType, context);
                });
    }

    default String getFullName() {
        return getSchema().getName().concat(".").concat(getName());
    }

    @Override
    default <T extends Feature> Optional<T> findFeature(FeatureId<T> id) {
        return findFeature(id.getId());
    }

    @Override
    default <T extends Feature> Optional<T> findFeature(String id) {
        return of(this.<T>getFeature(id))
                .filter(Optional::isPresent)
                .orElseGet(() -> getSchema().findFeature(id));
    }

    default List<Feature> findFeatures(Predicate<Feature> predicate) {
        return Stream.concat(getSchema().getFeatureList().stream(), getFeatureList().stream())
                .filter(predicate)
                .collect(Collectors.toList());

    }

    default List<Feature> findFeatures() {
        return findFeatures((feature -> true));
    }

    void merge(TableOrViewMetadata metadata);
}
