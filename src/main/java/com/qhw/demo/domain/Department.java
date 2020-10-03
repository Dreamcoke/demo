package com.qhw.demo.domain;

import java.io.Serializable;

/**
 * department
 * @author 
 */
public class Department implements Serializable {
    private Long deptId;

    private String deptName;

    private String deptDate;

    private String deptPhoneNumber;

    private String deptManger;

    private static final long serialVersionUID = 1L;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate;
    }

    public String getDeptPhoneNumber() {
        return deptPhoneNumber;
    }

    public void setDeptPhoneNumber(String deptPhoneNumber) {
        this.deptPhoneNumber = deptPhoneNumber;
    }

    public String getDeptManger() {
        return deptManger;
    }

    public void setDeptManger(String deptManger) {
        this.deptManger = deptManger;
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
        Department other = (Department) that;
        return (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptDate() == null ? other.getDeptDate() == null : this.getDeptDate().equals(other.getDeptDate()))
            && (this.getDeptPhoneNumber() == null ? other.getDeptPhoneNumber() == null : this.getDeptPhoneNumber().equals(other.getDeptPhoneNumber()))
            && (this.getDeptManger() == null ? other.getDeptManger() == null : this.getDeptManger().equals(other.getDeptManger()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptDate() == null) ? 0 : getDeptDate().hashCode());
        result = prime * result + ((getDeptPhoneNumber() == null) ? 0 : getDeptPhoneNumber().hashCode());
        result = prime * result + ((getDeptManger() == null) ? 0 : getDeptManger().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptDate=").append(deptDate);
        sb.append(", deptPhoneNumber=").append(deptPhoneNumber);
        sb.append(", deptManger=").append(deptManger);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}