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
 * @since 2019-11-06
 */
@TableName("register")
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 男0 1女
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 简历文件地址
     */
    private String fileurl;
    /**
     * 学历
     */
    private Integer education;
    /**
     * 日期 yyyy-MM-dd
     */
    private String date;
    /**
     * 应聘岗位id
     */
    private Integer jobId;
    /**
     * 民族
     */
    private String nation;
    /**
     * 学校
     */
    private String school;
    /**
     * 婚育情况
     */
    private String marriage;
    /**
     * 工作年限
     */
    private String workingyears;
    /**
     * 自我介绍信息
     */
    @TableField("Introduction")
    private String Introduction;
    /**
     * 专业
     */
    private String major;
    /**
     * 状态   0未查看  1已查看
     */
    private String status;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     *区县
     */
    private String county;
    
    
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getWorkingyears() {
		return workingyears;
	}
	public void setWorkingyears(String workingyears) {
		this.workingyears = workingyears;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + ", fileurl=" + fileurl + ", education=" + education + ", date=" + date
				+ ", jobId=" + jobId + ", nation=" + nation + ", school=" + school + ", marriage=" + marriage
				+ ", workingyears=" + workingyears + ", Introduction=" + Introduction + ", major=" + major + ", status="
				+ status + ", province=" + province + ", city=" + city + ", county=" + county + "]";
	}
	public Register() {
		super();
	}
	public Register(Long id, String name, Integer sex, Integer age, String phone, String email, String fileurl,
			Integer education, String date, Integer jobId, String nation, String school, String marriage,
			String workingyears, String introduction, String major, String status, String province, String city,
			String county) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.fileurl = fileurl;
		this.education = education;
		this.date = date;
		this.jobId = jobId;
		this.nation = nation;
		this.school = school;
		this.marriage = marriage;
		this.workingyears = workingyears;
		Introduction = introduction;
		this.major = major;
		this.status = status;
		this.province = province;
		this.city = city;
		this.county = county;
	}
	


   
}
