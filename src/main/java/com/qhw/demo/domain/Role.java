package com.qhw.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * role
 * @author 
 */
@ApiModel(description = "角色")
public class Role implements Serializable {

    @ApiModelProperty(name = "roleId",value = "角色id",example = "7")
    private Long roleId;
    @ApiModelProperty(name = "roleName",value = "角色名称",example = "后勤",required = true
    )
    private String roleName;
    @ApiModelProperty(name = "roleDate",value = "角色创建日期")
    private Date roleDate;
    @ApiModelProperty(name = "menuIds",value = "菜单集合ID")
    private Long[] menuIds;
    @ApiModelProperty(name = "deptIds",value = "部门集合ID")
    private Long[] deptIds;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getRoleDate() {
        return roleDate;
    }

    public void setRoleDate(Date roleDate) {
        this.roleDate = roleDate;
    }

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    public Long[] getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds) {
        this.deptIds = deptIds;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Role other = (Role) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleDate() == null ? other.getRoleDate() == null : this.getRoleDate().equals(other.getRoleDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleDate() == null) ? 0 : getRoleDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDate=").append(roleDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}