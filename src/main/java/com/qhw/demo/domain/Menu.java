package com.qhw.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * menu
 * @author 
 */
public class Menu implements Serializable {
    private Long menuId;

    private String menuName;

    private String menuPerms;

    private String menuComponents;

    private Date menuDate;

    private static final long serialVersionUID = 1L;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPerms() {
        return menuPerms;
    }

    public void setMenuPerms(String menuPerms) {
        this.menuPerms = menuPerms;
    }

    public String getMenuComponents() {
        return menuComponents;
    }

    public void setMenuComponents(String menuComponents) {
        this.menuComponents = menuComponents;
    }

    public Date getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(Date menuDate) {
        this.menuDate = menuDate;
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
        Menu other = (Menu) that;
        return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuPerms() == null ? other.getMenuPerms() == null : this.getMenuPerms().equals(other.getMenuPerms()))
            && (this.getMenuComponents() == null ? other.getMenuComponents() == null : this.getMenuComponents().equals(other.getMenuComponents()))
            && (this.getMenuDate() == null ? other.getMenuDate() == null : this.getMenuDate().equals(other.getMenuDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuPerms() == null) ? 0 : getMenuPerms().hashCode());
        result = prime * result + ((getMenuComponents() == null) ? 0 : getMenuComponents().hashCode());
        result = prime * result + ((getMenuDate() == null) ? 0 : getMenuDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuPerms=").append(menuPerms);
        sb.append(", menuComponents=").append(menuComponents);
        sb.append(", menuDate=").append(menuDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}