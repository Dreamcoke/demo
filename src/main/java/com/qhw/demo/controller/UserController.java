package com.qhw.demo.controller;

import com.qhw.demo.domain.Department;
import com.qhw.demo.domain.Role;
import com.qhw.demo.domain.User;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.*;
import com.qhw.demo.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.qhw.demo.service.RoleService;
import com.qhw.demo.service.UserService;
import com.qhw.demo.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/user/show")
@Api(tags = "用户管理接口")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "查看所有用户列表接口",notes = "返回用户信息，包括用户所属部门和角色id")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/list")
    public List<User> list(){
        List<User> list=userService.selectUser();
        return list;
    }
    @ApiOperation(value = "查看单个用户信息接口" ,notes ="查看单个用户信息接口(将所有部门和角色信息一并返回)" )
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/{userId}")
    @ApiImplicitParam(name = "userId", value = "用户id", defaultValue = "15", required = true,paramType ="path",dataType = "Long")
    public AjaxResult getInfo(@PathVariable long userId){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.put(AjaxResult.DATA_TAG,userService.selectByPrimaryKey(userId));
        List<Role> roleList=roleService.selectAllRole();
        ajaxResult.put("roleList",roleList);
        List<Department> departmentList=departmentService.selectAllDepartment();
        ajaxResult.put("departmentList",departmentList);
        ajaxResult.put("roleId",roleService.selectById(userId));
        ajaxResult.put("deptId",departmentService.selectById(userId));
        return ajaxResult;

    }
    @ApiOperation("新增用户接口")
    //@ApiImplicitParam(name = "用户",paramType = "body",required = true)
    @PreAuthorize("@ss.hasPermi()")
    @PostMapping
    public AjaxResult add( @Validated @RequestBody User user){
        if(1==userService.checkNameUnique(user.getUserName())){
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        user.setUserPassword(SecurityUtils.encryptPassword(user.getUserPassword()));
        return toAjax(userService.insert(user));
    }

    @ApiOperation("删除用户接口")
    @ApiImplicitParam(name ="userId",value = "用户id",defaultValue = "19",required = true)
    @PreAuthorize("@ss.hasPermi()")
    @DeleteMapping("/{userId}")
    public AjaxResult delete(@PathVariable  long userId){
        return toAjax(userService.deleteByPrimaryKey(userId));
    }

    @ApiOperation("修改用户接口")
    @PreAuthorize("@ss.hasPermi()")
    @PutMapping()
    public AjaxResult edit(@Validated @RequestBody User user){
        return toAjax(userService.updateByPrimaryKey(user));
    }
}
