package com.hlsfile.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hucheng
 * @since 2019-12-09
 */
@TableName("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "department_id", type = IdType.AUTO)
    private Long departmentId;
    private String departmentName;
    private Long departmentParentid;


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentParentid() {
        return departmentParentid;
    }

    public void setDepartmentParentid(Long departmentParentid) {
        this.departmentParentid = departmentParentid;
    }

    @Override
    public String toString() {
        return "Department{" +
        ", departmentId=" + departmentId +
        ", departmentName=" + departmentName +
        ", departmentParentid=" + departmentParentid +
        "}";
    }
}
