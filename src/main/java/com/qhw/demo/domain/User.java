package com.qhw.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@ApiModel(description = "用户")
public class User implements Serializable {
    @ApiModelProperty(value = "用户id",name = "userId",example = "17",required = true)
    private Long userId;

    @ApiModelProperty(value = "用户名称",name = "userName",example = "coke1111",required = true)
    private String userName;

    @ApiModelProperty(value = "用户密码",name = "userPassword",example = "sdsdsds",required = true)
    private String userPassword;

    @ApiModelProperty(value = "用户所属部门编号",name = "userDepartmentId",example = "1",required = true)
    private Long userDepartmentId;

    @ApiModelProperty(value = "用户电话",name = "userPhonenumber",example = "15912345678",required = true)
    private String userPhonenumber;

    @ApiModelProperty(value = "用户创建日期")
    private Date userDate;

    @ApiModelProperty(value = "角色id",name ="roleId",example = "1",required = true)
    private long roleId;

//    @ApiModelProperty(value = "部门")
//    private Department dept;

//    public Department getDept() {
//        return dept;
//    }
//
//    public void setDept(Department dept) {
//        this.dept = dept;
//    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUserDepartmentId() {
        return userDepartmentId;
    }

    public void setUserDepartmentId(Long userDepartmentId) {
        this.userDepartmentId = userDepartmentId;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
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
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserDepartmentId() == null ? other.getUserDepartmentId() == null : this.getUserDepartmentId().equals(other.getUserDepartmentId()))
            && (this.getUserPhonenumber() == null ? other.getUserPhonenumber() == null : this.getUserPhonenumber().equals(other.getUserPhonenumber()))
            && (this.getUserDate() == null ? other.getUserDate() == null : this.getUserDate().equals(other.getUserDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserDepartmentId() == null) ? 0 : getUserDepartmentId().hashCode());
        result = prime * result + ((getUserPhonenumber() == null) ? 0 : getUserPhonenumber().hashCode());
        result = prime * result + ((getUserDate() == null) ? 0 : getUserDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userDepartmentId=").append(userDepartmentId);
        sb.append(", userPhonenumber=").append(userPhonenumber);
        sb.append(", userDate=").append(userDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}