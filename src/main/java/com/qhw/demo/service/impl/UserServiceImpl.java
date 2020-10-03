package com.qhw.demo.service.impl;

import com.qhw.demo.domain.User;
import com.qhw.demo.domain.UserDepartmentKey;
import com.qhw.demo.domain.UserRoleKey;
import com.qhw.demo.mapper.RoleMapper;
import com.qhw.demo.mapper.UserDepartmentMapper;
import com.qhw.demo.mapper.UserMapper;
import com.qhw.demo.mapper.UserRoleMapper;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserDepartmentMapper userDepartmentMapper;
    @Override
    public List<User> selectUser(){
        List<User> userList=userMapper.selectByExample();
        return  userList;
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        //删除用户与部门关联
        userDepartmentMapper.deleteById(userId);
        //删除用户与角色关联
        userRoleMapper.deleteById(userId);
        //删除用户信息
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        int val1= userMapper.insert(record);
        int val2=insertUserRole(record);
        int val3=insertUserDept(record);
        return val1+val2+val3;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        long id=user.getUserId();
        //删除用户与角色关联
        userRoleMapper.deleteById(id);
        //新增用户与角色关联
        insertUserRole(user);
        //删除用户与部门关联
        userDepartmentMapper.deleteById(id);
        //新增用户与部门关联
        insertUserDept(user);
        //更新用户信息
        return userMapper.updateByPrimaryKey(user);
    }

    public int insertUserRole(User user){
        long roleId=user.getRoleId();
        long userId=user.getUserId();
        UserRoleKey userRoleKey=new UserRoleKey();
        userRoleKey.setRoleId(roleId);
        userRoleKey.setUserId(userId);
        return userRoleMapper.insert(userRoleKey);

    }
    public int  insertUserDept(User user){
        long deptId=user.getUserDepartmentId();
        long userId=user.getUserId();
        UserDepartmentKey userDepartmentKey=new UserDepartmentKey();
        userDepartmentKey.setDepartmentId(deptId);
        userDepartmentKey.setUserId(userId);
        return userDepartmentMapper.insert(userDepartmentKey);

    }

}
