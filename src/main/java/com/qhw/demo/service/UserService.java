package com.qhw.demo.service;

import com.qhw.demo.domain.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectUser();

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
