package com.qhw.demo.service;

import com.qhw.demo.domain.Menu;
import com.qhw.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MenuService {
    int deleteByPrimaryKey(Long menuId);

    List<Menu> selectAllMenu();

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    int update(Menu record);

    int updateByPrimaryKey(Menu record);

    boolean checkMenuExistRole(Long menuId);

    List<Menu> selectByUser(User user);

    List<Menu> selectByUserId(Long userId);
}