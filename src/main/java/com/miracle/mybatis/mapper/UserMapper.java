package com.miracle.mybatis.mapper;

import com.miracle.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : sungm
 * @date : 2021-01-20 16:37
 */
@Mapper
public interface UserMapper {

    /**
     * selectByUserId
     *
     * @param userId long
     * @return User
     */
    User selectByUserId(Long userId);

    /**
     * 不建议select all操作，这里只做测试用
     *
     * @return list
     */
    List<User> selectAllOrderByUserIdDesc();

    /**
     * insert user
     *
     * @param user u
     * @return int
     */
    @Insert("insert into base_user (user_name,remarks) values (#{userName},#{remarks})")
    Integer insertUser(User user);
}