package com.qhw.demo.mapper;

import com.qhw.demo.domain.DepartmentRoleKey;

public interface DepartmentRoleMapper {
    int deleteByPrimaryKey(DepartmentRoleKey key);

    int insert(DepartmentRoleKey record);

    int insertSelective(DepartmentRoleKey record);
}