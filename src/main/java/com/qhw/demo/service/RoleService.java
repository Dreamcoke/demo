package com.qhw.demo.service;

import com.qhw.demo.domain.Role;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    String deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Integer> selectById(Long roleId);

    List<Role> selectRoleByUserId(Long userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role role);

    List<Role> selectAllRole();

    Role selectRoleById(Long id);

    //int updateRoleDept(Role role);
}