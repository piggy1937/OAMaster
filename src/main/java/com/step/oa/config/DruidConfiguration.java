package com.step.oa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-18.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class,DatasourceProperties.class})
public class DruidConfiguration {
    @Autowired
    private DruidDataSourceProperties properties;
    @Autowired
    private DatasourceProperties datasourceProperties;
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(datasourceProperties.getDriverClassName());
        druidDataSource.setUrl(datasourceProperties.getUrl());
        druidDataSource.setUsername(datasourceProperties.getUsername());
        druidDataSource.setPassword(datasourceProperties.getPassword());
        druidDataSource.setInitialSize(properties.getInitialSize());
        druidDataSource.setMinIdle(properties.getMinIdle());
        druidDataSource.setMaxActive(properties.getMaxActive());
        druidDataSource.setMaxWait(properties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(properties.getValidationQuery());
        druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(properties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setConnectionProperties(properties.getConnectionProperties());
        try {
            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
       // sqlSessionFactoryBean.setTypeAliasesPackage("org.arrow.shop.bean");
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapping/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer cfg = new MapperScannerConfigurer();
//        cfg.setBasePackage("org.arrow.*.dao");
//        cfg.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        return cfg;
//    }
    @Bean("txManager")
    public PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
