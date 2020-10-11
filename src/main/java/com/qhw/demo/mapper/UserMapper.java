package com.qhw.demo.mapper;

import com.qhw.demo.domain.User;

import java.util.List;

public interface UserMapper {
    //long countByExample(UserExample example);

    //int deleteByExample(UserExample example);

    int deleteByPrimaryKey(long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample();

    User selectById(Long userId);

   // int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

   // int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsernameUnique(String userName);
}