package com.qhw.demo.service.impl;

import com.qhw.demo.domain.Department;
import com.qhw.demo.mapper.DepartmentMapper;
import com.qhw.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public int deleteByPrimaryKey(Long deptId) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Integer> selectById(Long userId) {
        return departmentMapper.selectById(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public int selectDepartmentByUserId(long id) {
        return 0;
    }
}
