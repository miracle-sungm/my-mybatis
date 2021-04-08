package com.miracle.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Objects;

/**
 * @author : sungm
 * @date : 2021-01-20 16:27
 */
public final class MybatisConfig {

    private MybatisConfig() {}

    private static SqlSessionFactory sqlSessionFactory = initSqlSessionFactory();

    /**
     * 初始化SqlSessionFactory
     *
     * @return SqlSessionFactory
     */
    private static SqlSessionFactory initSqlSessionFactory() {
        if (Objects.nonNull(sqlSessionFactory)) {
            return sqlSessionFactory;
        }
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception exception) {
            throw new RuntimeException("Fail to init SqlSessionFactory. " + exception.getMessage());
        }
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSessionFactory
     *
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
