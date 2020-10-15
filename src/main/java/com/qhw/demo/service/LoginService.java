package com.qhw.demo.service;

import com.qhw.demo.constants.Constants;
import com.qhw.demo.domain.User;

import java.util.List;
import javax.annotation.Resource;

//import com.qhw.demo.manager.AsyncManager;
//import com.qhw.demo.manager.factory.AsyncFactory;
import com.qhw.demo.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
//import com.qhw.demo.message.Constants;
import com.qhw.demo.domain.model.LoginUser;
import sun.misc.MessageUtils;


/**
 * 登录校验方法
 *
 * @author ruoyi
 */
@Component
public class LoginService
{
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisCache redisCache;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
//     * @param code 验证码
//     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password)
    {
        //String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
//        String captcha = redisCache.getCacheObject(verifyKey);
//        redisCache.deleteObject(verifyKey);
//        if (captcha == null)
//        {
//            return "登录失败";
//        }
//        if (!code.equalsIgnoreCase(captcha))
//        {
//            return "登录失败";
//        }
//        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                return ("密码不匹配");
            }
            else
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("登陆成功");
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
