package com.qhw.demo.service.impl;

import com.qhw.demo.domain.Police;
import com.qhw.demo.domain.model.LoginUser;
import com.qhw.demo.service.PoliceService;
import com.qhw.demo.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("policeDetailsServiceImpl")
public class PoliceDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private PoliceService policeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Police police=policeService.selectPoliceByUsername(username);
        if (StringUtils.isNull(police))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        return new LoginUser(police);
    }
}
