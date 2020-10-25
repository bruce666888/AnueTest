package com.anue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.anue.mapper")
public class AnueTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnueTestApplication.class,args);
	}

}
