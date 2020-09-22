package com.step.orm.rdb.operator.builder.fragments.query;

import com.step.orm.rdb.metadata.RDBFeatures;
import com.step.orm.rdb.metadata.TableOrViewMetadata;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;
import com.step.orm.rdb.operator.dml.Join;
import com.step.orm.rdb.operator.dml.JoinType;
import com.step.orm.rdb.operator.dml.query.QueryOperatorParameter;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@AllArgsConstructor(staticName = "of")
public class JoinFragmentBuilder implements QuerySqlFragmentBuilder {

    private TableOrViewMetadata metadata;

    @Override
    public SqlFragments createFragments(QueryOperatorParameter parameter) {

        PrepareSqlFragments fragments = PrepareSqlFragments.of();

        List<Join> joins = parameter.getJoins();

        for (Join join : joins) {
            metadata.getSchema()
                    .findTableOrView(join.getTarget())
                    .ifPresent(target -> {
                        ofNullable(join.getType())
                                .map(JoinType::name)
                                .ifPresent(fragments::addSql);
                        //join schema.table on
                        fragments.addSql("join")
                                .addSql(target.getFullName())
                                .addSql(join.getAlias())
                                .addSql("on");

                        fragments.addFragments(
                                target.getFeature(RDBFeatures.where)
                                        .map(builder -> {

                                            QueryOperatorParameter joinOnParameter = new QueryOperatorParameter();
                                            joinOnParameter.setFrom(target.getName());
                                            joinOnParameter.setFromAlias(join.getAlias());
                                            if(join.getTerms()!=null) {
                                                joinOnParameter.getWhere().addAll(join.getTerms());
                                            }
                                            return builder.createFragments(joinOnParameter);
                                        })
                                        .filter(SqlFragments::isNotEmpty)
                                        .orElseThrow(() -> new IllegalArgumentException("join terms is empty"))
                        );
                    });

        }

        return fragments;
    }

    @Override
    public String getId() {
        return join;
    }

    @Override
    public String getName() {
        return "表连接";
    }
}
