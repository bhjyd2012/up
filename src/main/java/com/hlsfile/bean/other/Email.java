package com.hlsfile.bean.other;

/**   
 * @ClassName:  Email   
 * @Description:TODO(邮件实体类)   
 * @author: hucheng 
 * @date:   2019年11月12日 下午2:31:12       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
public class Email {
	private String sender; 
	private String userName; 
	private String password;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Email() {
		super();
	}
	public Email(String sender, String userName, String password) {
		super();
		this.sender = sender;
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Email [sender=" + sender + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
