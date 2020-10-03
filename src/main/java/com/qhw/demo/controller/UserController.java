package com.qhw.demo.controller;

import com.qhw.demo.domain.Department;
import com.qhw.demo.domain.Role;
import com.qhw.demo.domain.User;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.qhw.demo.service.RoleService;
import com.qhw.demo.service.UserService;
import com.qhw.demo.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/user/show")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/list")
    public List<User> list(){
        List<User> list=userService.selectUser();
        return list;
    }

    @GetMapping("/{userId}")
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

    @PostMapping
    public AjaxResult add(@Validated @RequestBody User user){
        return toAjax(userService.insert(user));
    }
    @DeleteMapping("/{userId}")
    public int delete(@PathVariable  long userId){
        return userService.deleteByPrimaryKey(userId);
    }

    @PutMapping()
    public int edit(@Validated @RequestBody User user){
        return userService.updateByPrimaryKey(user);
    }
}
