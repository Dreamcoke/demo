package com.qhw.demo.service.impl;

import com.qhw.demo.domain.Role;
import com.qhw.demo.mapper.RoleMapper;
import com.qhw.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public List<Integer> selectById(Long roleId) {
        List<Integer> list=roleMapper.selectById(roleId);
        return list;
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public int selectRoleByUserId(long id) {
        return 0;
    }
}
