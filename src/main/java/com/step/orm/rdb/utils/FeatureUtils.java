package com.step.orm.rdb.utils;

import com.step.orm.core.FeatureType;
import com.step.orm.core.meta.Feature;
import com.step.orm.core.meta.FeatureSupportedMetadata;
import com.step.orm.core.meta.ObjectMetadata;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public class FeatureUtils {

    private static boolean r2dbcIsAlive;

    static {
        try {
            Class.forName("io.r2dbc.spi.Connection");
            r2dbcIsAlive = true;
        } catch (ClassNotFoundException e) {
            r2dbcIsAlive = false;
        }

    }

    public static boolean r2dbcIsAlive() {
        return r2dbcIsAlive;
    }


    public static String featureToString(List<Feature> features) {
        StringBuilder builder = new StringBuilder();

        Map<FeatureType, List<Feature>> featureMap = features
                .stream()
                .collect(Collectors.groupingBy(Feature::getType
                        , () -> new TreeMap<>(Comparator.comparing(FeatureType::getId))
                        , Collectors.toList()));

        for (Map.Entry<FeatureType, List<Feature>> entry : featureMap.entrySet()) {
            builder.append("--").append(entry.getKey().getId())
                    .append(" (").append(entry.getKey().getName())
                    .append(")")
                    .append("\n");
            for (Feature feature : entry.getValue()) {
                builder.append("-----|---- ")
                        .append(feature.getId())
                        .append(" (")
                        .append(feature.getName())
                        .append(")")
                        .append("\t").append(feature.getClass().getSimpleName())
                        .append("\n");
            }
        }

        return builder.toString();
    }

    public static String metadataToString(ObjectMetadata metadata) {
        StringBuilder builder = new StringBuilder();

        builder.append(metadata.getObjectType().getId())
                .append("(")
                .append(metadata.getObjectType().getName())
                .append(")");

        if (metadata instanceof FeatureSupportedMetadata) {
            builder.append("\n")
                    .append(featureToString(((FeatureSupportedMetadata) metadata).getFeatureList()));
        }


        return builder.toString();

    }

}

