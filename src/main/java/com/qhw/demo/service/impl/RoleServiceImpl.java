package com.qhw.demo.service.impl;

import com.qhw.demo.domain.DepartmentRoleKey;
import com.qhw.demo.domain.Role;
import com.qhw.demo.domain.RoleMenuKey;
import com.qhw.demo.domain.UserRoleKey;
import com.qhw.demo.mapper.DepartmentRoleMapper;
import com.qhw.demo.mapper.RoleMapper;
import com.qhw.demo.mapper.RoleMenuMapper;
import com.qhw.demo.mapper.UserRoleMapper;
import com.qhw.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private DepartmentRoleMapper departmentRoleMapper;

    @Override
    public String deleteByPrimaryKey(Long roleId) {
        if(countUserRoleByRoleId(roleId)>0){
            return "该角色已绑定用户，删除失败";
        }
        if( roleMapper.deleteByPrimaryKey(roleId)==1){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public int insert(Role role) {
        roleMapper.insert(role);
        inserRoleDept(role);
        return  insertRoleMenu(role);
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
    public int updateByPrimaryKey(Role role) {
        roleMapper.updateByPrimaryKey(role);
        roleMenuMapper.deleteByPrimaryKey(role.getRoleId());
        return insertRoleMenu(role);
    }

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public Role selectRoleById(Long id) {
        return roleMapper.selectRoleById(id);
    }

    public int countUserRoleByRoleId(Long id){
        return userRoleMapper.countUserRoleByRoleId(id);
    }

    public int insertRoleMenu(Role role){
        List<RoleMenuKey> list=new ArrayList<>();
        for(Long menId:role.getMenuIds()){
            RoleMenuKey roleMenuKey=new RoleMenuKey();
            roleMenuKey.setMenuId(menId);
            roleMenuKey.setRoleId(role.getRoleId());
            list.add(roleMenuKey);
        }
        return roleMenuMapper.batchinsert(list);
    }

    public int inserRoleDept(Role role){
        List<DepartmentRoleKey> list=new ArrayList<>();
        for(Long deptId:role.getDeptIds()){
            DepartmentRoleKey departmentRoleKey=new DepartmentRoleKey();
            departmentRoleKey.setDepartmentId(deptId);
            departmentRoleKey.setRoleId(role.getRoleId());
            list.add(departmentRoleKey);
        }
        return departmentRoleMapper.batchinsert(list);
    }
}
