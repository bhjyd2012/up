package com.hlsfile.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneAndEmailUtils {

		//验证是否是邮箱格式
			public static boolean isEmail(String str) {
				String regex = "^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(str);
				return matcher.matches();
			}
			
		//验证是否是手机号格式
			private static boolean isNumLegal(String str) {
				//String regex = "^[1](([3][0-9])|([4][5,7,9])|([5][4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";//
				String regex = "^1[3|4|5|6|7|8|9][0-9]{9}$";//
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(str);
				return matcher.matches();
			}


		    /**
			 * 验证手机号码
			 * @param mobiles
			 * @return resultValidateForm
			 */
			public static boolean isMobileNO(String mobiles) {
				boolean flag = false;
				if (mobiles.length() != 11) {
					return flag;
				} else{
					//Pattern p = Pattern.compile("^1[3|4|5|6|7|8|9][0-9]{9}$"); // 验证手机号
					Pattern p = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$"); // 验证手机号
					Matcher m = p.matcher(mobiles);
					flag = m.matches();		
					return flag;
				}
			}
			
			/**
			 * 验证邮箱
			 * @param mail
			 * @return resultValidateForm
			 */
			public static boolean isMailNO(String mail) {
				boolean flag = false;
				String mailName="^[0-9a-z]+\\w*";       //^表明一行以什么开头；^[0-9a-z]表明要以数字或小写字母开头；\\w*表明匹配任意个大写小写字母或数字或下划线
				String mailDomain="([0-9a-z]+\\.)+[0-9a-z]+$";       //***.***.***格式的域名，其中*为小写字母或数字;第一个括号代表有至少一个***.匹配单元，而[0-9a-z]$表明以小写字母或数字结尾
				String mailRegex=mailName+"@"+mailDomain;
				Pattern p = Pattern.compile(mailRegex); // 验证邮箱
				Matcher m = p.matcher(mail);
				flag = m.matches();		
				return flag;
			}
			
			
			/**   
			 * @Title: isNumeric   
			 * @Description: TODO(验证是否为数字)   
			 * @param: @param str
			 * @param: @return      
			 * @return: boolean      
			 * @throws   
			 */  
			public static boolean isNumeric(String s){
				if (s != null && !"".equals(s.trim()))
			        return s.matches("^[0-9]*$");
			    else
			        return false;

				}

}
