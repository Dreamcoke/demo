package com.qhw.demo.service;

import com.qhw.demo.domain.UserDepartmentKey;
import org.springframework.stereotype.Service;

@Service
public interface UserDepartmentService {
    int deleteByPrimaryKey(UserDepartmentKey key);

    int insert(UserDepartmentKey record);

    int insertSelective(UserDepartmentKey record);

}