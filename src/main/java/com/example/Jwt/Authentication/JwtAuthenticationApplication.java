package com.example.Jwt.Authentication;

import com.example.Jwt.Authentication.util.JwtUtil;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

import java.util.Base64;

@SpringBootApplication
public class JwtAuthenticationApplication {


	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
		System.out.println("Running..");
		//System.out.println(new String(Base64.getEncoder().encode("arunkumararun@1234".getBytes())));

		JwtUtil jwtUtil=new JwtUtil();


	}

}
