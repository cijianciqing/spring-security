/**
 * 
 */
package cj.springboot.security.template.security;

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

//		if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {//loginType 默认设置JSON
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString( CJAjaxResult.success("cj authentication success")));

//		} else {
//			super.onAuthenticationSuccess(request, response, authentication);
//		}

	}

}
