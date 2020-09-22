package com.step.orm.core.meta;

import com.step.orm.core.CastUtil;
import com.step.orm.core.FeatureId;
import com.step.orm.core.FeatureType;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 支持元数据的特性类型
 */
public interface FeatureSupportedMetadata {

    Map<String, Feature> getFeatures();

    void addFeature(Feature feature);

    default List<Feature> getFeatureList() {
        return Optional.ofNullable(getFeatures())
                .map(Map::values)
                .<List<Feature>>map(ArrayList::new)
                .orElseGet(Collections::emptyList);
    }

    default <T extends Feature> List<T> getFeatures(FeatureType type) {

        return ofNullable(getFeatures())
                .map(features -> features.values()
                        .stream()
                        .filter(feature -> feature.getType().equals(type))
                        .map(CastUtil::<T>cast)
                        .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);

    }

    default <T extends Feature> Optional<T> getFeature(FeatureId<T> id) {
        return getFeature(id.getId());
    }

    default <T extends Feature> T getFeatureNow(FeatureId<T> id) {
        return getFeatureNow(id.getId());
    }

    default <T extends Feature> Optional<T> findFeature(FeatureId<T> id) {
        return getFeature(id.getId());
    }

    default <T extends Feature> T findFeatureNow(FeatureId<T> id) {
        return this.findFeatureNow(id.getId());
    }

    default <T extends Feature> Optional<T> findFeature(String id) {
        return getFeature(id);
    }

    default <T extends Feature> T findFeatureNow(String id) {
        return this.<T>findFeature(id)
                .orElseThrow(() -> new UnsupportedOperationException("unsupported feature " + id));
    }

    default <T extends Feature> T getFeatureNow(String id) {
        return this.<T>getFeature(id)
                .orElseThrow(() -> new UnsupportedOperationException("unsupported feature " + id));
    }

    default <T extends Feature> Optional<T> getFeature(String id) {
        return ofNullable(getFeatures())
                .map(feature -> feature.get(id))
                .map(CastUtil::cast);
    }

    default <T extends Feature> Optional<T> getFeature(Feature target) {
        return ofNullable(getFeatures())
                .map(feature -> feature.get(target.getId()))
                .map(CastUtil::cast);
    }

    default boolean supportFeature(String id) {
        return getFeature(id).isPresent();
    }

    default boolean supportFeature(Feature feature) {
        return getFeature(feature.getId()).isPresent();
    }

}
