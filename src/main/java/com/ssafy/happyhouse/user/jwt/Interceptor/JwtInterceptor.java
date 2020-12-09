package com.ssafy.happyhouse.user.jwt.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.happyhouse.user.jwt.service.JwtService;

/**
/**
* @className   : JwtInterceptor
* @author 	   : parkjaehyun
* @description : Json-Web-Token 인터셉터 클래스로, HandlerInterceptor 를 상속받아 인터셉트과정을 구현
* @Log ↓↓↓
* ============================================================================
* DATE       	   AUTHOR  	       NOTE
* ----------------------------------------------------------------------------
* 2020-11-21       parkjaehyun     최초생성
*/

@Component
public class JwtInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/**
		 * @methodName  : preHandle
		 * @params      : [request, response, handler]
		 * @return      : boolean
		 * @description : 서블릿에서 컨트롤러가 호출되기전에 인터셉터가 요청으 가로채 해당 메서드를 먼저 수행함.
		 * 				  request Header에 담겨진 AuthToken 값의 유효성 검사를 통해 인증과정을 수행
		 *
		 */
		if(request.getMethod().contentEquals("OPTIONS")) {
			return true;
		}
		else {
			String token = request.getHeader("auth-token");
			if(token != null && token.length() > 0) {
				jwtService.checkValid(token);
				return true;
			}
			else {
				throw new RuntimeException("인증 토큰이 만료되었습니다.");
			}
		}
	}
}
