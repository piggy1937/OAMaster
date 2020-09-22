package com.step.orm.rdb.metadata.key;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

import com.step.orm.core.meta.ObjectMetadata;
import com.step.orm.core.meta.ObjectType;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.metadata.RDBObjectType;
import com.step.orm.rdb.metadata.TableOrViewMetadata;
import com.step.orm.rdb.operator.dml.JoinType;

import java.util.List;
import java.util.Optional;

/**
 * 外键
 * @see ForeignKeyBuilder
 */
public interface ForeignKeyMetadata extends ObjectMetadata {

    @Override
    default ObjectType getObjectType() {
        return RDBObjectType.foreignKey;
    }

    /**
     * @return 是否为逻辑外键
     */
    boolean isLogical();

    /**
     * @return 是否n对多
     */
    boolean isToMany();

    AssociationType getType();

    TableOrViewMetadata getSource();

    TableOrViewMetadata getTarget();

    List<ForeignKeyColumn> getColumns();

    boolean isAutoJoin();

    //自动关联表类型
    JoinType getJoinType();

    List<Term> getTerms();

    Optional<ForeignKeyMetadata> getMiddleForeignKey(String name);

    List<ForeignKeyMetadata> getMiddleForeignKeys();
}
