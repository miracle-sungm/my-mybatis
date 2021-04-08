package com.miracle.mybatis;

import com.miracle.mybatis.config.MybatisConfig;
import com.miracle.mybatis.entity.User;
import com.miracle.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author : sungm
 * @date : 2021-01-20 16:46
 */
public class TestUserMapper {

    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByUserId(1L);
            System.out.println(user.toString());
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("miracle");
        user.setRemarks("test insert");
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Integer row = userMapper.insertUser(user);
            //mybatis-config.xml配置了JDBC事务，所以这里一定要手动提交事务
            sqlSession.commit();
            System.out.println(row);
        }
    }

    @Test
    public void selectAllOrderByUserIdDesc() {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.selectAllOrderByUserIdDesc();
            System.out.println(users.toString());
        }
    }

}
