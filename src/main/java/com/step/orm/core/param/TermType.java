package com.step.orm.core.param;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-21.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
/**
 * 提供默认支持的查询条件类型,用于动态指定查询条件
 *
 * @author zhouhao
 * @since 1.0
 */
public interface TermType {
    /**
     * ==
     *
     * @since 1.0
     */
    String eq      = "eq";
    /**
     * !=
     *
     * @since 1.0
     */
    String not     = "not";
    /**
     * like
     *
     * @since 1.0
     */
    String like    = "like";
    /**
     * not like
     *
     * @since 1.0
     */
    String nlike   = "nlike";
    /**
     * >
     *
     * @since 1.0
     */
    String gt      = "gt";
    /**
     * <
     *
     * @since 1.0
     */
    String lt      = "lt";
    /**
     * >=
     *
     * @since 1.0
     */
    String gte     = "gte";
    /**
     * <=
     *
     * @since 1.0
     */
    String lte     = "lte";
    /**
     * in
     *
     * @since 1.0
     */
    String in      = "in";
    /**
     * notin
     *
     * @since 1.0
     */
    String nin     = "nin";
    /**
     * =''
     *
     * @since 1.0
     */
    String empty   = "empty";
    /**
     * !=''
     *
     * @since 1.0
     */
    String nempty  = "nempty";
    /**
     * is null
     *
     * @since 1.0
     */
    String isnull  = "isnull";
    /**
     * not null
     *
     * @since 1.0
     */
    String notnull = "notnull";
    /**
     * between
     *
     * @since 1.0
     */
    String btw     = "btw";
    /**
     * not between
     *
     * @since 1.0
     */
    String nbtw    = "nbtw";

}
