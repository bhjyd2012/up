package com.hlsfile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.hlsfile.mapper")//扫描mapper包
@EnableScheduling//开启定时支持
@EnableTransactionManagement//开启事务支持
public class HlsrecruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlsrecruitApplication.class, args);
	}

}
