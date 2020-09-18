package com.step.oa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-18.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Getter
@Setter
public class DruidDataSourceProperties {
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;
}
