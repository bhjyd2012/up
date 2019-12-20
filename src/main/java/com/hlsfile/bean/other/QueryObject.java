package com.hlsfile.bean.other;

/**   
 * @ClassName:  QueryObject   
 * @Description:TODO(查询条件分装)   
 * @author: hucheng 
 * @date:   2019年11月6日 上午11:34:36       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
public class QueryObject {
	private String title;//标题信息
	private String startDate;//开始时间
	private String endDate;//结束时间
	private String level1;//省份
	private String level2;//城市
	private String cid;//公司
	private String source;//来源
	
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLevel1() {
		return level1;
	}
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	public String getLevel2() {
		return level2;
	}
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	public QueryObject() {
		super();
	}
	public QueryObject(String title, String startDate, String endDate, String level1, String level2, String cid,
			String source) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.level1 = level1;
		this.level2 = level2;
		this.cid = cid;
		this.source = source;
	}
	@Override
	public String toString() {
		return "QueryObject [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", level1="
				+ level1 + ", level2=" + level2 + ", cid=" + cid + ", source=" + source + "]";
	}
	
	
}
