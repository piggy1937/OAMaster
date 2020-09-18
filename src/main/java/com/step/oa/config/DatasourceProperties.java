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
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
public class DatasourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
