package com.step.orm.rdb.metadata;

import com.step.orm.core.FeatureId;
import com.step.orm.rdb.operator.builder.fragments.function.SimpleFunctionFragmentBuilder;
import com.step.orm.rdb.operator.builder.fragments.query.QuerySqlFragmentBuilder;
import com.step.orm.rdb.operator.builder.fragments.term.*;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface RDBFeatures {


    FeatureId<QuerySqlFragmentBuilder> where = FeatureId.of(QuerySqlFragmentBuilder.where);

    FeatureId<QuerySqlFragmentBuilder> select = FeatureId.of(QuerySqlFragmentBuilder.selectColumns);
    FeatureId<QuerySqlFragmentBuilder> selectJoin = FeatureId.of(QuerySqlFragmentBuilder.join);
    FeatureId<QuerySqlFragmentBuilder> orderBy = FeatureId.of(QuerySqlFragmentBuilder.sortOrder);

    /*通用查询条件*/
    SymbolTermFragmentBuilder eq = new SymbolTermFragmentBuilder("eq", "等于", "=");

    SymbolTermFragmentBuilder not = new SymbolTermFragmentBuilder("not", "不等于", "!=");

    SymbolTermFragmentBuilder like = new SymbolTermFragmentBuilder("like", "模糊匹配", "like");
    SymbolTermFragmentBuilder nlike = new SymbolTermFragmentBuilder("nlike", "不模糊匹配", "not like");

    SymbolTermFragmentBuilder gt = new SymbolTermFragmentBuilder("gt", "大于", ">");
    SymbolTermFragmentBuilder lt = new SymbolTermFragmentBuilder("lt", "小于", "<");
    SymbolTermFragmentBuilder gte = new SymbolTermFragmentBuilder("gte", "大于等于", ">=");
    SymbolTermFragmentBuilder lte = new SymbolTermFragmentBuilder("lte", "小于等于", "<=");

    BetweenAndTermFragmentBuilder between = new BetweenAndTermFragmentBuilder("btw", "在...之间", false);
    BetweenAndTermFragmentBuilder notBetween = new BetweenAndTermFragmentBuilder("nbtw", "不在...之间", true);


    InTermFragmentBuilder in = new InTermFragmentBuilder("in", "在...之中", false);
    InTermFragmentBuilder notIn = new InTermFragmentBuilder("nin", "不在...之中", true);

    EmptyTermFragmentBuilder isEmpty = new EmptyTermFragmentBuilder("empty", "为空字符", false);
    EmptyTermFragmentBuilder notEmpty = new EmptyTermFragmentBuilder("notempty", "不为空字符", true);

    NullTermFragmentBuilder isNull = new NullTermFragmentBuilder("isnull", "为null", false);
    NullTermFragmentBuilder notNull = new NullTermFragmentBuilder("notnull", "不为null", true);



    /*===============函数==============*/

    /*==聚合函数==*/
    SimpleFunctionFragmentBuilder count = new SimpleFunctionFragmentBuilder("count", "计数");
    SimpleFunctionFragmentBuilder sum = new SimpleFunctionFragmentBuilder("sum", "求和");
    SimpleFunctionFragmentBuilder avg = new SimpleFunctionFragmentBuilder("avg", "平均值");
    SimpleFunctionFragmentBuilder max = new SimpleFunctionFragmentBuilder("max", "最大值");
    SimpleFunctionFragmentBuilder min = new SimpleFunctionFragmentBuilder("min", "最小值");

}
