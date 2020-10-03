package com.qhw.demo.service;

import com.qhw.demo.domain.UserRoleKey;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);


}