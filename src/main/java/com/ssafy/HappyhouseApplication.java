package com.ssafy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.user.jwt.Interceptor.JwtInterceptor;

@SpringBootApplication
public class HappyhouseApplication  implements WebMvcConfigurer{
	public static void main(String[] args) {
		SpringApplication.run(HappyhouseApplication.class, args);
	}

	/* jwt인터셉터 객체 불러오기 */
	@Autowired
	private JwtInterceptor jwtInterceptor;

	/* JwtInterceptor 설치 => 인터셉터 적용할 경로와 제외할 경로 설정 (제외경로는, 인터셉터 요청을 필요로 하지 않는 곳을 의미) */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**")
				.excludePathPatterns(Arrays.asList("/user/login","/user","/user/check/**","/user/forgot/**"));	// 여기 진료소나 병원,맵 등 추가 수정필요함
	}
	
	/* 흐음? => 인터셉터를 이용하여 처리하므로, 전역의 Cors Orgin 처리를 해준다. */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("auth-token");
  }
}
