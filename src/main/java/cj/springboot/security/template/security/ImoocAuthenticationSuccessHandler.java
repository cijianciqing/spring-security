/**
 * 
 */
package cj.springboot.security.template.security;

import cj.springboot.security.template.util.jwt.CJJWTUtil;
import cj.springboot.security.template.util.jwt.JwtUtil;
import cj.springboot.security.template.util.redis.CJRedisCache;
import cn.com.ns.cj.cjuniversalspringbootstarter.returnData.CJAjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


/**
 * @author zhailiang
 *
 * 认证成功处理器
 */
@Slf4j
@Component("imoocAuthenticationSuccessHandler")
public class ImoocAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


	//spring自动注册的
	//将authentication转换为json
	@Autowired
	private ObjectMapper objectMapper;


	@Autowired
	CJRedisCache cjRedisCache;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

		log.info("com.ns.cjcq.security.authentication.ImoocAuthenticationSuccessHandler.onAuthenticationSuccess 登录成功");

		/*
		 * 保存token到redis
		 * */
		CJUser loginUser = (CJUser) authentication.getPrincipal();
		String userId = loginUser.getId().toString();
		String jwt = CJJWTUtil.createJWT(userId);
		//authenticate存入redis
		cjRedisCache.setCacheObject("login:"+userId,loginUser);
		//把token响应给前端
		HashMap<String,String> map = new HashMap<>();
		map.put("token",jwt);


//		if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {//loginType 默认设置JSON
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString( CJAjaxResult.success("cj authentication success",map)));

//		} else {
//			super.onAuthenticationSuccess(request, response, authentication);
//		}


	}

}
