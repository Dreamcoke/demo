package com.qhw.demo.controller;

import com.qhw.demo.domain.Menu;
import com.qhw.demo.message.AjaxResult;
import com.qhw.demo.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理
 *
 */
@Api(tags = "菜单管理接口")
@RestController
@RequestMapping("/menu/show")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;


    @ApiOperation("查看所有菜单列表接口")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/list")
    public List<Menu> list(){
        return menuService.selectAllMenu();
    }

    @ApiOperation("查看单个菜单接口")
    @ApiImplicitParam(name ="menuId" ,value = "菜单ID",defaultValue = "2",required = true,paramType = "path",dataType = "Long")
    @PreAuthorize("@ss.hasPermi()")
    @GetMapping("/{menuId}")
    public Menu getMenu(@PathVariable Long menuId){
        return menuService.selectByPrimaryKey(menuId);
    }

    @ApiOperation("修改菜单接口")
    @PreAuthorize("@ss.hasPermi()")
    @PutMapping
    public AjaxResult update(@RequestBody Menu menu){
        return toAjax(menuService.update(menu));
    }

    @ApiOperation("删除菜单接口")
    @ApiImplicitParam(name = "menuId",value = "菜单id",defaultValue = "3",required = true,paramType = "path",dataType = "Long")
    @PreAuthorize("@ss.hasPermi()")
    @DeleteMapping("/{menuId}")
    public AjaxResult deleteMenu(@PathVariable Long menuId){
        if (menuService.checkMenuExistRole(menuId)){
            return AjaxResult.error("该菜单已分配，删除失败");
        }
        return toAjax(menuService.deleteByPrimaryKey(menuId));
    }

    @ApiOperation("增加菜单接口")
    @PreAuthorize("@ss.hasPermi()")
    @PostMapping
    public AjaxResult add(@RequestBody Menu menu){
        return toAjax(menuService.insert(menu));
    }

}
