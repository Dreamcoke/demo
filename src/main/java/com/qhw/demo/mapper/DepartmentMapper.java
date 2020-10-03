package com.qhw.demo.mapper;

import com.qhw.demo.domain.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Integer> selectById(Long userId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAllDepartment();

    int selectDepartmentByUserId(long id);

}