package com.qhw.demo.service;

import com.qhw.demo.domain.RoleMenuKey;

public interface RoleMenuService {
    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);
}