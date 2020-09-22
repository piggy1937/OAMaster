package com.step.orm.rdb.operator.builder.fragments.query;

import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.TableOrViewMetadata;
import com.step.orm.rdb.operator.builder.fragments.EmptySqlFragments;
import com.step.orm.rdb.operator.builder.fragments.PrepareSqlFragments;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;
import com.step.orm.rdb.operator.builder.fragments.function.FunctionFragmentBuilder;
import com.step.orm.rdb.operator.dml.query.QueryOperatorParameter;
import com.step.orm.rdb.operator.dml.query.SortOrder;
import lombok.AllArgsConstructor;

import static java.util.Optional.ofNullable;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@AllArgsConstructor(staticName = "of")
public class SortOrderFragmentBuilder implements QuerySqlFragmentBuilder {

    private TableOrViewMetadata metadata;

    @Override
    public SqlFragments createFragments(QueryOperatorParameter parameter) {
        PrepareSqlFragments fragments = PrepareSqlFragments.of();

        int index = 0;
        for (SortOrder sortOrder : parameter.getOrderBy()) {
            SqlFragments orderFragments = createOrder(sortOrder, parameter);
            if (orderFragments.isNotEmpty()) {
                if (index++ != 0) {
                    fragments.addSql(",");
                }
                fragments.addFragments(orderFragments);
            }
        }

        return fragments;
    }

    private SqlFragments createOrder(String fullName, RDBColumnMetadata column, SortOrder order) {


        SqlFragments fragments = ofNullable(order.getFunction())
                .flatMap(function -> column.findFeature(FunctionFragmentBuilder.createFeatureId(function)))
                .map(builder -> builder.create(fullName, column, order.getOpts()))
                .orElseGet(() -> PrepareSqlFragments.of().addSql(fullName));


        return PrepareSqlFragments.of()
                .addFragments(fragments)
                .addSql(order.getOrder().name());
    }

    private SqlFragments createOrder(SortOrder order, QueryOperatorParameter parameter) {
        String column = order.getColumn();
        if (column.contains(".")) {
            String[] arr = column.split("[.]");
            if (arr[0].equals(parameter.getFrom()) || arr[0].equals(parameter.getFromAlias())) {
                column = arr[1];
            } else {
                //关联表
                return parameter.findJoin(arr[0])
                        .flatMap(join ->
                                metadata.getSchema()
                                        .getTableOrView(join.getTarget())
                                        .flatMap(table -> table.getColumn(arr[1]))
                                        .map(joinColumn -> createOrder(joinColumn.getFullName(join.getAlias()), joinColumn, order))
                        )
                        .orElse(EmptySqlFragments.INSTANCE);
            }
        }

        return metadata.getColumn(column)
                .map(orderColumn -> createOrder(orderColumn.getFullName(parameter.getFromAlias()), orderColumn, order))
                .orElse(EmptySqlFragments.INSTANCE);
    }


    @Override
    public String getId() {
        return sortOrder;
    }

    @Override
    public String getName() {
        return "排序";
    }
}
