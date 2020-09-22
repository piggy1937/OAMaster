package com.step.orm.core.meta;

import com.step.orm.core.FeatureType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ObjectMetadataParser extends Feature {
    @Override
    default FeatureType getType() {
        return DefaultFeatureType.metadataParser;
    }

    ObjectType getObjectType();

    Optional<? extends ObjectMetadata> parseByName(String name);

    List<? extends ObjectMetadata> parseAll();

    Mono<? extends ObjectMetadata> parseByNameReactive(String name);

    Flux<? extends ObjectMetadata> parseAllReactive();

}
