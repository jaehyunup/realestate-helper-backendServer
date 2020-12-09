package com.ssafy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.user.jwt.Interceptor.JwtInterceptor;

/**
* @className   : HappyhouseApplication
* @author 	   : parkjaehyun
* @description : Spring boot Main Application
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-10-24       parkjaehyun     최초생성
*/
@SpringBootApplication
public class HappyhouseApplication  implements WebMvcConfigurer{
	@Autowired
	private JwtInterceptor jwtInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(HappyhouseApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * @methodName  : addInterceptors
		 * @params      : [registry]
		 * @return      : void
		 * @description : JWT 인증 인터셉터에 대한 설정.
		 *
		 */
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**")
				.excludePathPatterns(Arrays.asList("/user/login","/user","/user/check/**","/user/forgot/**"));	// 여기 진료소나 병원,맵 등 추가 수정필요함
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		/**
		 * @methodName  : addCorsMappings
		 * @params      : [registry]
		 * @return      : void
		 * @description : CORS 해결을 위해 헤더에 관련정보를 추가하는 로직
		 */
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*")
				.exposedHeaders("auth-token");
  }
}
