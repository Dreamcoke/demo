package com.qhw.demo.service.impl;

import com.qhw.demo.domain.Menu;
import com.qhw.demo.domain.User;
import com.qhw.demo.mapper.MenuMapper;
import com.qhw.demo.mapper.RoleMenuMapper;
import com.qhw.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public List<Menu> selectByUser(User user) {
        return null;
    }

    @Override
    public List<Menu> selectByUserId(Long userId) {
        return menuMapper.selectByUserId(userId);
    }

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return menuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public List<Menu> selectAllMenu() {
        return menuMapper.selectAllMenu();
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Long menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int update(Menu record) {
        return menuMapper.update(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    @Override
    public boolean checkMenuExistRole(Long menuId) {
        int result=roleMenuMapper.checkMenuExistRole(menuId);
        return result>0? true:false;
    }
}
