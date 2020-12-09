package com.ssafy;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
* @className   : MybatisConfiguration
* @author 	   : parkjaehyun
* @description : MyBatis 설정을 위한 Configuration class
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-10-28       parkjaehyun     최초생성
*/
@Configuration
@MapperScan(basePackages="com.ssafy.happyhouse.mappers")
public class MybatisConfiguration {

    @Bean
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        /**
         * @methodName  : sqlSessionFactory
         * @params      : [dataSource]
         * @return      : org.apache.ibatis.session.SqlSessionFactory
         * @description : myBatis sqlSessionFactory 및 DataSource 의존 주입, Mapper path도 설정
         *
         */
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
        /**
         * @methodName  : sqlSession
         * @params      : [sqlSessionFactory]
         * @return      : org.mybatis.spring.SqlSessionTemplate
         * @description : Mybatis SqlSessionTemplate에 위에서 의존주입한 Factory 주입
         *
         */
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
