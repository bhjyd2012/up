package com.hlsfile.bean;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
 * @since 2019-11-07
 */
@TableName("job_info")
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 所属公司id
     */
    private Integer cid;
    /**
     * 省编号
     */
    private String provinceCode;
    /**
     * 城市编号
     */
    private String cityCode;
    /**
     * 职位名称
     */
    private String title;
    /**
     * 部门
     */
    private Integer department;
    /**
     * 薪资起
     */
    private Integer rewardStart;
    /**
     * 薪资止
     */
    private Integer rewardEnd;
    /**
     * 岗位职责
     */
    private String responsibility;
    /**
     * 岗位要求
     */
    private String require;
    /**
     * 学历 0不限 1大专  2本科   3研究生以上
     */
    private Integer education;
    /**
     * 状态   0未发布   1已发布
     */
    private Integer status;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 工作年限
     */
    private String workingyears;
    /**
     * 二维码保存路径
     */
    @TableField("QR_path")
    private String qrPath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getRewardStart() {
        return rewardStart;
    }

    public void setRewardStart(Integer rewardStart) {
        this.rewardStart = rewardStart;
    }

    public Integer getRewardEnd() {
        return rewardEnd;
    }

    public void setRewardEnd(Integer rewardEnd) {
        this.rewardEnd = rewardEnd;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getWorkingyears() {
        return workingyears;
    }

    public void setWorkingyears(String workingyears) {
        this.workingyears = workingyears;
    }

    public String getQrPath() {
        return qrPath;
    }

    public void setQrPath(String qrPath) {
        this.qrPath = qrPath;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
        ", id=" + id +
        ", cid=" + cid +
        ", provinceCode=" + provinceCode +
        ", cityCode=" + cityCode +
        ", title=" + title +
        ", department=" + department +
        ", rewardStart=" + rewardStart +
        ", rewardEnd=" + rewardEnd +
        ", responsibility=" + responsibility +
        ", require=" + require +
        ", education=" + education +
        ", status=" + status +
        ", publishDate=" + publishDate +
        ", workingyears=" + workingyears +
        ", qrPath=" + qrPath +
        "}";
    }
}
