package com.qhw.demo.mapper;

import com.qhw.demo.domain.UserRoleKey;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int deleteById(long id);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    int countUserRoleByRoleId(Long id);
}