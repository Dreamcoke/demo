package com.qhw.demo.mapper;

import com.qhw.demo.domain.Role;
import com.qhw.demo.domain.RoleMenuKey;

import java.util.List;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role role);

    int insertSelective(RoleMenuKey record);

    int batchinsert(List<RoleMenuKey> list);

    int checkMenuExistRole(Long menuId);
}