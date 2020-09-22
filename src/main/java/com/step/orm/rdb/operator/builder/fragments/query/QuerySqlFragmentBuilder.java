package com.step.orm.rdb.operator.builder.fragments.query;

import com.step.orm.core.FeatureType;
import com.step.orm.core.meta.Feature;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;
import com.step.orm.rdb.operator.dml.query.QueryOperatorParameter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface QuerySqlFragmentBuilder extends Feature {

    //feature id
    String where = "queryTermsFragmentBuilder";
    String selectColumns = "selectColumnFragmentBuilder";
    String join = "joinSqlFragmentBuilder";
    String sortOrder = "sortOrderFragmentBuilder";


    @Override
    default FeatureType getType() {
        return RDBFeatureType.fragment;
    }

    SqlFragments createFragments(QueryOperatorParameter parameter);

}