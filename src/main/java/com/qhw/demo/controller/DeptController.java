package com.qhw.demo.controller;

import com.qhw.demo.domain.Department;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.DepartmentService;
import com.qhw.demo.service.UserDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "部门管理接口")
@RequestMapping("/dept/show")
@RestController
public class DeptController extends BaseController {
    @Autowired
    DepartmentService departmentService;

    @ApiOperation("查看部门列表接口")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/list")
    public List<Department> list(){
        return departmentService.selectAllDepartment();
    }

    @ApiOperation("查看某个部门信息接口")
    @ApiImplicitParam(name ="deptId",value = "部门id",required = true,defaultValue = "2",paramType = "path",dataType = "Long")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/{deptId}")
    public Department getDept(@PathVariable Long deptId){
        return departmentService.selectDepartmentById(deptId);
    }

    @ApiOperation("修改部门接口")
    @PreAuthorize("@ss.hasPermi()")
    @PutMapping
    public AjaxResult edit(@RequestBody Department department){
        return toAjax(departmentService.updateByPrimaryKey(department));
    }
    @ApiOperation("增加部门接口")
    @PreAuthorize("@ss.hasPermi()")
    @PostMapping
    public AjaxResult add(@RequestBody Department department){
        return toAjax(departmentService.insert(department));
    }

    @ApiOperation("删除部门接口")
    @ApiImplicitParam(name = "deptId",value = "部门id",defaultValue = "3",required = true,dataType = "Long",paramType = "path")
    @PreAuthorize("@ss.hasPermi()")
    @DeleteMapping("/{deptId}")
    public AjaxResult delt(@PathVariable Long deptId){
        if (departmentService.checkDeptHasUser(deptId)){
            return AjaxResult.error("该部门存在用户，删除失败");
        }
        return toAjax(departmentService.deleteByPrimaryKey(deptId));
    }

}
