package com.qhw.demo.service;

import com.qhw.demo.domain.DepartmentRoleKey;

public interface DepartmentRoleService {
    int deleteByPrimaryKey(DepartmentRoleKey key);

    int insert(DepartmentRoleKey record);

    int insertSelective(DepartmentRoleKey record);
}