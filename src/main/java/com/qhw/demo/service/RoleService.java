package com.qhw.demo.service;

import com.qhw.demo.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    String deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Integer> selectById(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role role);

    List<Role> selectAllRole();

    Role selectRoleById(Long id);

    //int updateRoleDept(Role role);
}