package com.qhw.demo.service.impl;

import com.qhw.demo.domain.Department;
import com.qhw.demo.mapper.DepartmentMapper;
import com.qhw.demo.mapper.UserDepartmentMapper;
import com.qhw.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    UserDepartmentMapper userDepartmentMapper;
    @Override
    public int deleteByPrimaryKey(Long deptId) {
        return departmentMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Integer> selectById(Long userId) {
        return departmentMapper.selectByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public Department selectDepartmentById(long id) {
        return departmentMapper.selectDepartmentById(id);
    }

    @Override
    public boolean checkDeptHasUser(Long deptId) {
        int result=userDepartmentMapper.checkDeptHasUser(deptId);
        return result>0? true:false;
    }
}
