package com.hlsfile;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hlsfile.utils.SendMail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendEmail {
   
	@Test
	public void sendemail() {
		SendMail sendEmail=new SendMail();
		//设置要发送的邮箱
		sendEmail.setReceiveMailAccount("1278993876@qq.com");
		//创建10位发验证码
		Random random=new Random();
		String str="";
		for(int i=0;i<10;i++) {
			int n=random.nextInt(10);
			str+=n;
		}
		sendEmail.setInfo(str);
		try {
			sendEmail.Send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
