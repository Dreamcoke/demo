package com.qhw.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qhw.demo.domain.Department;
import com.qhw.demo.domain.Role;
import com.qhw.demo.service.*;
import com.qhw.demo.utils.JwtUtils;
import com.qhw.demo.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.qhw.demo.constants.Constants;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.domain.Menu;
import com.qhw.demo.domain.User;
import com.qhw.demo.domain.model.LoginBody;
import com.qhw.demo.domain.model.LoginUser;
import com.qhw.demo.utils.ServletUtils;
import com.qhw.demo.service.LoginService;
import com.qhw.demo.service.MenuService;
import com.qhw.demo.service.TokenService;
import com.qhw.demo.service.MenuService;

import javax.annotation.Resource;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@Api(tags = "登录接口")
@RestController
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

//    @Autowired
//    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @ApiOperation(value = "验证用户信息接口",notes = "验证用户信息,生成token")
    @PostMapping("/login/test")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax=new AjaxResult();
        Map<String,Object> playload=new HashMap<>();
        // 查詢是否用戶存在
        //User  user = userService.login(loginBody.getUsername(), loginBody.getPassword());
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword()));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        //LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        System.out.println(authentication);
        LoginUser loginUser=(LoginUser) authentication.getPrincipal();
        User user=loginUser.getUser();
        if (user==null){
             return AjaxResult.error();
        }
        playload.put("userId",user.getUserId());
        playload.put("userName",user.getUserName());
        String token=JwtUtils.getToken(playload);
        ajax.put("staus",true);
        ajax.put("msg","认证成功");
        //ajax.put("user",user);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

//    @GetMapping("/login/info")
//    public User getLoginInfo(Authentication authentication){
//        return (User)authentication.getPrincipal();
//    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/login/getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        User user=loginUser.getUser();
        //User user = loginUser.getUser();
        // 角色集合
        List<Role> roles = roleService.selectRoleByUserId(user.getUserId());
        // 部门集合
        List<Department> departments = departmentService.selectDepartmentByUserId(user.getUserId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("departments", departments);
        return ajax;
    }

    /**
     * 获取菜单路由信息
     *
     * @return 菜单路由信息
     */
    @GetMapping("/login/getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
       // User user = userService.getUser();
        List<Menu> menus = menuService.selectByUserId(loginUser.getUser().getUserId());
        System.out.println(menus);
        return AjaxResult.success(menus);
    }
}

