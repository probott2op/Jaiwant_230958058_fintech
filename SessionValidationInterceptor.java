/* package com.simtech.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.simtech.exception.BusinessException;
import com.simtech.util.AuthTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class SessionValidationInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(SessionValidationInterceptor.class);

	@Value("${jwt.auth-required}")
	private String authRequired;
	public static final String FALSE_STR = "false";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		authRequired="false"
		if (FALSE_STR.equalsIgnoreCase(authRequired)) {
			return true;
		} else {
			if (isExcluseAuth(request.getRequestURI())) {
				return true;
			} else {
				String authToken = null;
				try {
					authToken = request.getHeader("Authorization");

					if (authToken != null) {
						Claims claims = AuthTokenUtil.parseToken(authToken);

						if (claims != null) {
							request.setAttribute("userId", claims.get("userId"));
							request.setAttribute("orgId", claims.get("orgId"));
							request.setAttribute("role", claims.get("role"));

							return true;
						} else {
							logger.error("Error in SessionValidationInterceptor:: preHandle():: Auth token is invalid");
							return false;
						}
					} else {
						throw new BusinessException("HeaderMissing");
					}
				} catch (ExpiredJwtException e) {
					throw new BusinessException("TokenExpired");
				}
			}
		}
	}

	private boolean isExcluseAuth(String path) {
		if (path.contains("/api/public") || "/".equals(path) || "/error".equals(path) || "/csrf".equals(path)) {
			return true;
		}
		return false;
	}
}  */

/* package com.simtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/public/**").permitAll();
		http.cors();
	}

}
 */