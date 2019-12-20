package com.hlsfile.bean;

import com.baomidou.mybatisplus.annotations.TableField;
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
 * @since 2019-12-10
 */
@TableName("local_department")
public class LocalDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id 与钉钉对应
     */
    @TableId(value = "local_id", type = IdType.AUTO)
    private Long localId;
    /**
     * 部门名称
     */
    private String localName;
    /**
     * 总部-分部
     */
    private Integer localLevel;
    @TableField("QR_path")
    private String qrPath;


    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Integer getLocalLevel() {
        return localLevel;
    }

    public void setLocalLevel(Integer localLevel) {
        this.localLevel = localLevel;
    }

    public String getQrPath() {
        return qrPath;
    }

    public void setQrPath(String qrPath) {
        this.qrPath = qrPath;
    }

    @Override
    public String toString() {
        return "LocalDepartment{" +
        ", localId=" + localId +
        ", localName=" + localName +
        ", localLevel=" + localLevel +
        ", qrPath=" + qrPath +
        "}";
    }
}
