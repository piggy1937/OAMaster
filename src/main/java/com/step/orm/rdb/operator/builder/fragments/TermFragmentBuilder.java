package com.step.orm.rdb.operator.builder.fragments;
import com.step.orm.core.FeatureId;
import com.step.orm.core.meta.Feature;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBColumnMetadata;
import com.step.orm.rdb.metadata.RDBFeatureType;
/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * SQL条件片段构造器
 *
 * @since 4.0.0
 */
public interface TermFragmentBuilder extends Feature {

    static FeatureId<TermFragmentBuilder> createFeatureId(String suffix){
        return FeatureId.of(RDBFeatureType.termType.getId().concat(":").concat(suffix.toLowerCase()));
    }

    @Override
    default String getId() {
        return getType().getFeatureId(getTermType().toLowerCase());
    }

    @Override
    default RDBFeatureType getType() {
        return RDBFeatureType.termType;
    }

    String getTermType();

    SqlFragments createFragments(String columnFullName, RDBColumnMetadata column, Term term);

}
