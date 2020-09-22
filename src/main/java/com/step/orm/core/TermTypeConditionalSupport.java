package com.step.orm.core;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
public interface TermTypeConditionalSupport {

    /**
     * 条件接收器,用于处理接受到的条件并进行对应的操作如{@link Term.Type#and}
     *
     * @param <T>
     */
    interface Accepter<T,O> {
        T accept(String column, String termType, O value);
    }

    interface SimpleAccepter<T,O> {
        T accept(String column, O value);
    }

}

