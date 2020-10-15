package com.qhw.demo.mapper;

import com.qhw.demo.domain.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    List<Menu> selectAllMenu();

    int update(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectByUserId(Long userId);
}