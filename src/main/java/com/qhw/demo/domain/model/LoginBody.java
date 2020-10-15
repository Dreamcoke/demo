package com.qhw.demo.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登录对象
 *
 * @author ruoyi
 */
@ApiModel(description = "登录用户信息")
public class LoginBody
{
    /**
     * 用户名
     */
    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "coke")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty(name = "password",value = "密码",required = true,example = "sdsdsds")
    private String password;

//    /**
//     * 验证码
//     */
//    @ApiModelProperty(name = "code",value = "验证码",required = true,example = "8")
//    private String code;
//
//    /**
//     * 唯一标识
//     */
//    @ApiModelProperty(name = "uuid",value = "标识",required = true,example = "4b6b451fcbdf4605a5f9300e1f30ec44")
//    private String uuid = "";

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

//    public String getCode()
//    {
//        return code;
//    }
//
//    public void setCode(String code)
//    {
//        this.code = code;
//    }
//
//    public String getUuid()
//    {
//        return uuid;
//    }
//
//    public void setUuid(String uuid)
//    {
//        this.uuid = uuid;
//    }
}

