package com.step.orm.rdb.operator.builder.fragments.term;

import com.step.orm.core.FeatureId;
import com.step.orm.core.FeatureType;
import com.step.orm.core.meta.Feature;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBFeatureType;
import com.step.orm.rdb.metadata.key.ForeignKeyMetadata;
import com.step.orm.rdb.operator.builder.fragments.SqlFragments;

import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface ForeignKeyTermFragmentBuilder extends Feature {

    String idValue = "foreignKeyTermFragmentBuilder";

    FeatureId<ForeignKeyTermFragmentBuilder> ID = FeatureId.of(idValue);

    @Override
    default String getId() {
        return idValue;
    }

    @Override
    default String getName() {
        return getType().getName();
    }

    @Override
    default FeatureType getType() {
        return RDBFeatureType.foreignKeyTerm;
    }

    SqlFragments createFragments(String tableName, ForeignKeyMetadata key, List<Term> terms);


}
