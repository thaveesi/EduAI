//package com.example.EduAI;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//@SpringBootApplication
//@ComponentScan({"com.example.EduAI", "com.other.package"})
//public class EduAiApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EduAiApplication.class, args);
//	}
//
//}

package com.example.EduAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.EduAI", "com.other.package"})
public class EduAiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EduAiApplication.class, args);
	}

}
