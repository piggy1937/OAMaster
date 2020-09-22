package com.step.orm.rdb.operator.builder;

import lombok.AllArgsConstructor;
import com.step.orm.rdb.executor.SqlRequest;
import com.step.orm.rdb.metadata.RDBSchemaMetadata;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.metadata.TableOrViewMetadata;
import com.step.orm.rdb.operator.builder.fragments.*;
import com.step.orm.rdb.operator.builder.fragments.query.QuerySqlBuilder;
import com.step.orm.rdb.operator.builder.fragments.query.QuerySqlFragmentBuilder;
import com.step.orm.rdb.operator.dml.query.QueryOperatorParameter;
import static com.step.orm.rdb.metadata.RDBFeatures.*;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@AllArgsConstructor(staticName = "of")
public class DefaultQuerySqlBuilder implements QuerySqlBuilder {

    protected RDBSchemaMetadata schema;

    protected Optional<SqlFragments> select(QueryOperatorParameter parameter, TableOrViewMetadata metadata) {
        return metadata.getFeature(select)
                .map(builder -> builder.createFragments(parameter))
                .filter(SqlFragments::isNotEmpty);
    }

    protected Optional<SqlFragments> where(QueryOperatorParameter parameter, TableOrViewMetadata metadata) {
        return metadata.getFeature(where)
                .map(builder -> builder.createFragments(parameter))
                .filter(SqlFragments::isNotEmpty);
    }

    protected Optional<SqlFragments> join(QueryOperatorParameter parameter, TableOrViewMetadata metadata) {
        return metadata.getFeature(selectJoin)
                .map(builder -> builder.createFragments(parameter))
                .filter(SqlFragments::isNotEmpty);
    }

    protected Optional<SqlFragments> orderBy(QueryOperatorParameter parameter, TableOrViewMetadata metadata) {
        return metadata.getFeature(orderBy)
                .map(builder -> builder.createFragments(parameter))
                .filter(SqlFragments::isNotEmpty);
    }

    protected SqlRequest build(TableOrViewMetadata metadata, QueryOperatorParameter parameter) {
        BlockSqlFragments fragments = BlockSqlFragments.of();

        fragments.addBlock(FragmentBlock.before, "select");

        fragments.addBlock(FragmentBlock.selectColumn, select(parameter, metadata)
                .orElseGet(() -> PrepareSqlFragments.of().addSql("*")));

        fragments.addBlock(FragmentBlock.selectFrom, PrepareSqlFragments.of()
                .addSql("from")
                .addSql(metadata.getFullName())
                .addSql(parameter.getFromAlias()));


        join(parameter, metadata)
                .ifPresent(join -> fragments.addBlock(FragmentBlock.join, join));
        //where

        where(parameter, metadata)
                .ifPresent(where ->
                        fragments.addBlock(FragmentBlock.where,"where")
                                .addBlock(FragmentBlock.where, where));

        //group by

        //having

        //order by
        orderBy(parameter,metadata)
                .ifPresent(order-> fragments.addBlock(FragmentBlock.orderBy,"order by")
                        .addBlock(FragmentBlock.orderBy, order));

        if (Boolean.TRUE.equals(parameter.getForUpdate())) {
            fragments.addBlock(FragmentBlock.after, PrepareSqlFragments.of().addSql("for update"));
        }
        //分页
        else if (parameter.getPageIndex() != null && parameter.getPageSize() != null) {
            return metadata.<Paginator>findFeature(RDBFeatureType.paginator.getId())
                    .map(paginator -> paginator.doPaging(fragments, parameter.getPageIndex(), parameter.getPageSize()))
                    .map(SqlFragments::toRequest)
                    .orElseGet(fragments::toRequest);

        }
        return fragments.toRequest();
    }

    @Override
    public SqlRequest build(QueryOperatorParameter parameter) {
        String from = parameter.getFrom();
        if (from == null || from.isEmpty()) {
            throw new UnsupportedOperationException("from table or view not set");
        }
        TableOrViewMetadata metadata = schema.findTableOrView(from)
                .orElseThrow(() -> new UnsupportedOperationException("table or view [" + from + "] doesn't exist "));

        return build(metadata, parameter);
    }
}
