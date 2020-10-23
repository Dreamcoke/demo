package com.qhw.demo.service.impl;

import com.qhw.demo.domain.DepartmentRoleKey;
import com.qhw.demo.domain.Police;
import com.qhw.demo.domain.Role;
import com.qhw.demo.domain.RoleMenuKey;
import com.qhw.demo.mapper.*;
import com.qhw.demo.service.PoliceService;
import com.qhw.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoliceServiceImpl implements PoliceService{
    @Autowired
    private PoliceMapper policeMapper;

    @Override
    public Police selectPoliceByUsername(String username) {
        return policeMapper.selectPoliceByUsername(username);
    }
}
