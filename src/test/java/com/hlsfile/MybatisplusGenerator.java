package com.hlsfile;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/*
 * 这个类是mybatisplus自动代码生成的工具类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusGenerator{

	@Test
	public void testGenerator() {
		System.out.println("开始自动生成代码.......................");

		// 1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false) // 是否支持AR模式
				.setAuthor("hucheng") // 作者是谁???
				.setOutputDir("E:\\javawork\\mybatisplus代码生成") // 生成的代码保存的位置
				.setFileOverride(true) // 文件覆盖
				.setIdType(IdType.AUTO) // 主键自动增长策略
				.setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I
				.setBaseResultMap(true) // 有可能有用
				.setBaseColumnList(true); // 有可能有用

		// 2. 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL) // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://localhost:3306/hls_job?useUnicode=true&characterEncoding=utf8")
				.setUsername("root").setPassword("root");
		
		// 3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setTablePrefix(new String[]{""}) // 设置表名的前缀
				.setInclude(new String[]{"local_department"}); // 需要逆向生成的表(可生成多个表) 生成的表
		
		// 4. 包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.hlsfile")
				.setMapper("mapper") // com.house.mapper
				.setService("service") // com.house.service
				.setController("controller") // com.house.controller
				.setEntity("bean") // com.house.bean
				.setXml("mapper"); // 配置文件的位置
		// 5. 整合配置
		AutoGenerator ag = new AutoGenerator();
		ag.setGlobalConfig(config)//全局配置
				.setDataSource(dsConfig)//数据源配置
				.setStrategy(stConfig)//策略配置
				.setPackageInfo(pkConfig);//包名策略配置

		// 6. 执行
		ag.execute();

		System.out.println("自动生成代码完毕.......................");
	}
	
}

