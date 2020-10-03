package com.qhw.demo.service;

import com.qhw.demo.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Integer> selectById(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRole();

    int selectRoleByUserId(long id);
}