package com.qhw.demo.service;

import com.qhw.demo.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    int deleteByPrimaryKey(Long deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Integer> selectById(Long deptId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAllDepartment();

    int selectDepartmentByUserId(long id);
}