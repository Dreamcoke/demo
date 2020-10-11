package com.qhw.demo.mapper;

import com.qhw.demo.domain.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Integer> selectById(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    Role selectRoleById(Long id);
}