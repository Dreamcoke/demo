package com.qhw.demo.service.impl;

import com.qhw.demo.domain.User;
//import com.ruoyi.common.core.domain.model.LoginUser;
//import com.ruoyi.common.enums.UserStatus;
//import com.ruoyi.common.exception.BaseException;
import com.qhw.demo.domain.model.LoginUser;
import com.qhw.demo.utils.StringUtils;
import com.qhw.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 *
 * @author ruoyi
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

//    @Autowired
//    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        return new LoginUser(user);
    }

//    public UserDetails createLoginUser(SysUuser user)
//    {
//        return new LoginUser(user, permissionService.getMenuPermission(user));
//    }
}
