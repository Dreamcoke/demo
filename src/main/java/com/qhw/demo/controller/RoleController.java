package com.qhw.demo.controller;

import com.qhw.demo.domain.Role;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 角色管理
 *
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/role/show")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;


    @ApiOperation("查看所有角色列表接口")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/list")
    public List<Role> list(){
        return roleService.selectAllRole();
    }
    @ApiOperation("查看某个角色信息接口")
    @ApiImplicitParam(name = "roleId",value = "角色id",defaultValue = "1",required = true,dataType = "Long")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/{roleId}")
    public Role getRole(@PathVariable Long roleId){
        return roleService.selectRoleById(roleId);
    }


    @ApiOperation("增加角色接口")
    @PreAuthorize("@ss.hasPermi()")
    @PostMapping
    public AjaxResult add(@RequestBody Role role){
        return toAjax(roleService.insert(role));
    }
    @ApiOperation("修改角色信息接口")
    @PreAuthorize("@ss.hasPermi()")
    @PutMapping
    public AjaxResult update(@RequestBody Role role){
        return toAjax(roleService.updateByPrimaryKey(role));
    }

    @ApiOperation("删除单个角色接口")
    @ApiImplicitParam(name = "roleId",value = "用户id",defaultValue = "15",required = true, dataType ="Long")
    @PreAuthorize("@ss.hasPermi()")
    @DeleteMapping("/{roleId}")
    public AjaxResult delRole(@PathVariable Long roleId)  {
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.put("message",roleService.deleteByPrimaryKey(roleId));
        ajaxResult.put(AjaxResult.CODE_TAG,"200");
        return ajaxResult;
    }

}
