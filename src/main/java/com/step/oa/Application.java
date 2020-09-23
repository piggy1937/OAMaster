package com.step.oa;

import com.step.oa.config.DatasourceProperties;
import com.step.oa.config.DruidDataSourceProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.step.oa.mapper")
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class);
    }
}
