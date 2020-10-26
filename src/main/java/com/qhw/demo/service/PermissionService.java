package com.qhw.demo.service;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
//import com.ruoyi.common.core.domain.entity.SysRole;
import com.qhw.demo.domain.model.LoginUser;
import com.qhw.demo.utils.ServletUtils;
import com.qhw.demo.utils.StringUtils;

/**
 * RuoYi首创 自定义权限实现，ss取自SpringSecurity首字母
 *
 * @author ruoyi
 */
@Service("ss")
public class PermissionService
{
    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";

    /** 管理员角色权限标识 */
    private static final String SUPER_ADMIN = "admin";

    private static final String ROLE_DELIMETER = ",";

    private static final String PERMISSION_DELIMETER = ",";

    @Autowired
    private TokenService tokenService;

    /**
     * 验证token
     *
     * @param
     * @return 用户是否具备token
     */
    public boolean hasPermi()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (StringUtils.isNull(loginUser))
        {
            return false;
        }
        return true;
    }
}