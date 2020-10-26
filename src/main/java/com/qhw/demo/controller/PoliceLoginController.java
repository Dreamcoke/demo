package com.qhw.demo.controller;

import com.qhw.demo.constants.Constants;
import com.qhw.demo.domain.Police;
import com.qhw.demo.domain.User;
import com.qhw.demo.domain.model.LoginBody;
import com.qhw.demo.domain.model.LoginUser;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.security.token.PoliceUsernamePasswordAuthenticationToken;
import com.qhw.demo.utils.JwtUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PoliceLoginController {

    @Resource
    private AuthenticationManager authenticationManager;
    @PreAuthorize("@ss.hasPermi()")
    @PostMapping("/policelogin/test")
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
                    .authenticate(new PoliceUsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword()));
        }
        catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                //密码不匹配，需自定义返回前台消息
                System.out.println("密码不匹配");
            }
        }
        //LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        System.out.println(authentication);
        LoginUser loginUser=(LoginUser) authentication.getPrincipal();
        Police police=(Police) loginUser.getPolice();
        if (police==null){
            return AjaxResult.error();
        }
        playload.put("userId",police.getUserId());
        playload.put("userName",police.getUserName());
        String token= JwtUtils.getToken(playload);
        ajax.put("staus",true);
        ajax.put("msg","认证成功");
        //ajax.put("user",user);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}
