package com.qhw.demo.mapper;

import com.qhw.demo.domain.UserDepartmentKey;

public interface UserDepartmentMapper {
    int deleteByPrimaryKey(UserDepartmentKey key);

    int deleteById(long id);

    int insert(UserDepartmentKey record);

    int insertSelective(UserDepartmentKey record);

    int checkDeptHasUser(Long deptId);
}