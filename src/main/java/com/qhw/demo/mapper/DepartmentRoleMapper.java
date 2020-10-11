package com.qhw.demo.mapper;

import com.qhw.demo.domain.DepartmentRoleKey;

import java.util.List;

public interface DepartmentRoleMapper {
    int deleteByPrimaryKey(DepartmentRoleKey key);

    int batchinsert(List<DepartmentRoleKey> list);

    int insertSelective(DepartmentRoleKey record);
}