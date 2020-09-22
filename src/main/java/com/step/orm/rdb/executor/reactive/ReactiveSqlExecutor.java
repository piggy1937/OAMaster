package com.step.orm.rdb.executor.reactive;

import com.step.orm.core.FeatureId;
import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.executor.SqlRequests;
import com.step.orm.rdb.executor.wrapper.ResultWrapper;
import com.step.orm.rdb.executor.wrapper.ResultWrappers;
import com.step.orm.rdb.metadata.RDBFeatureType;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ReactiveSqlExecutor extends Feature {

    String ID_VALUE = "reactiveSqlExecutor";
    FeatureId<ReactiveSqlExecutor> ID = FeatureId.of(ID_VALUE);

    @Override
    default String getId() {
        return ID_VALUE;
    }

    @Override
    default String getName() {
        return "响应式SQL执行器";
    }

    @Override
    default RDBFeatureType getType() {
        return RDBFeatureType.sqlExecutor;
    }

    Mono<Integer> update(Publisher<SqlRequest> request);

    Mono<Void> execute(Publisher<SqlRequest> request);

    <E> Flux<E> select(Publisher<SqlRequest> request, ResultWrapper<E, ?> wrapper);

    default Mono<Void> execute(SqlRequest request) {
        return execute(Mono.just(request));
    }

    default Mono<Integer> update(SqlRequest request) {
        return update(Mono.just(request));
    }

    default Mono<Integer> update(String sql, Object... args) {
        return update(SqlRequests.of(sql, args));
    }

    default <E> Flux<E> select(String sql, ResultWrapper<E, ?> wrapper) {
        return select(SqlRequests.of(sql), wrapper);
    }

    default Flux<Map<String, Object>> select(String sql, Object... args) {
        return select(SqlRequests.of(sql, args), ResultWrappers.map());
    }

    default <E> Flux<E> select(SqlRequest sqlRequest, ResultWrapper<E, ?> wrapper) {
        return select(Mono.just(sqlRequest), wrapper);
    }

}
