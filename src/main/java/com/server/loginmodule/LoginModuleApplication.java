package com.server.loginmodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.server.loginmodule.mapper")
@SpringBootApplication
public class LoginModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginModuleApplication.class, args);
	}

}
