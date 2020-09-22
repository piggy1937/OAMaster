package com.step.orm.rdb.operator.builder.fragments;

import com.step.orm.core.param.SqlTerm;
import com.step.orm.core.param.Term;
import com.step.orm.rdb.operator.builder.FragmentBlock;
import com.step.orm.rdb.utils.PropertiesUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public abstract class AbstractTermsFragmentBuilder<T> {

    @Setter
    @Getter
    private boolean useBlock = false;

    private BlockSqlFragments createBlockFragments(T parameter, List<Term> terms) {
        BlockSqlFragments fragments = BlockSqlFragments.of();

        int index = 0;
        boolean termAvailable;
        boolean lastTermAvailable = false;
        for (Term term : terms) {
            index++;
            SqlFragments termFragments;
            if (term instanceof SqlTerm) {
                termFragments = PrepareSqlFragments.of()
                        .addSql(((SqlTerm) term).getSql())
                        .addParameter(PropertiesUtils.convertList(term.getValue()));
            } else {
                termFragments = term.getValue() == null ? EmptySqlFragments.INSTANCE : createTermFragments(parameter, term);
            }

            termAvailable = termFragments.isNotEmpty();
            if (termAvailable) {
                BlockSqlFragments termBlock = BlockSqlFragments.of();

                if (index != 1 && lastTermAvailable) {
                    //and or
                    termBlock.addBlock(FragmentBlock.before, term.getType().name());
                }
                termBlock.addBlock(FragmentBlock.term, termFragments);
                fragments.addBlock(FragmentBlock.term, termBlock);
                lastTermAvailable = termAvailable;
            }
            BlockSqlFragments nestBlock = BlockSqlFragments.of();

            List<Term> nest = term.getTerms();
            //嵌套条件
            if (nest != null && !nest.isEmpty()) {
                //递归....
                SqlFragments nestFragments = createTermFragments(parameter, nest);
                if (nestFragments.isNotEmpty()) {
                    //and or
                    if (termAvailable || lastTermAvailable) {
                        nestBlock.addBlock(FragmentBlock.before, term.getType().name());
                    }
                    nestBlock.addBlock(FragmentBlock.before, "(");
                    nestBlock.addBlock(FragmentBlock.term, nestFragments);
                    nestBlock.addBlock(FragmentBlock.after, ")");

                    fragments.addBlock(FragmentBlock.term, nestBlock);
                    lastTermAvailable = true;
                    continue;
                }
            }


        }

        return fragments;
    }

    private PrepareSqlFragments createPrepareFragments(T parameter, List<Term> terms) {
        PrepareSqlFragments fragments = PrepareSqlFragments.of();

        int index = 0;
        boolean termAvailable;
        boolean lastTermAvailable = false;
        for (Term term : terms) {
            index++;
            SqlFragments termFragments;
            if (term instanceof SqlTerm) {
                termFragments = PrepareSqlFragments.of()
                        .addSql(((SqlTerm) term).getSql())
                        .addParameter(PropertiesUtils.convertList(term.getValue()));
            } else {
                termFragments = term.getValue() == null ? EmptySqlFragments.INSTANCE : createTermFragments(parameter, term);
            }

            termAvailable = termFragments.isNotEmpty();
            if (termAvailable) {
                if (index != 1 && lastTermAvailable) {
                    //and or
                    fragments.addSql(term.getType().name());
                }
                fragments.addFragments(termFragments);
                lastTermAvailable = termAvailable;
            }

            List<Term> nest = term.getTerms();
            //嵌套条件
            if (nest != null && !nest.isEmpty()) {
                //递归....
                SqlFragments nestFragments = createTermFragments(parameter, nest);
                if (nestFragments.isNotEmpty()) {
                    //and or
                    if (termAvailable || lastTermAvailable) {
                        fragments.addSql(term.getType().name());
                    }
                    fragments.addSql("(");
                    fragments.addFragments(nestFragments);
                    fragments.addSql(")");
                    lastTermAvailable = true;
                    continue;
                }
            }

        }

        return fragments;
    }

    protected SqlFragments createTermFragments(T parameter, List<Term> terms) {
        return isUseBlock() ? createBlockFragments(parameter, terms) : createPrepareFragments(parameter, terms);
    }

    protected abstract SqlFragments createTermFragments(T parameter, Term term);

}
