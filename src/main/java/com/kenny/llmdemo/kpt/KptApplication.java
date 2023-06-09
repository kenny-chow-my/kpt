package com.kenny.llmdemo.kpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class KptApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication application = new SpringApplication(KptApplication.class);
		application.run(args);

	}

}
