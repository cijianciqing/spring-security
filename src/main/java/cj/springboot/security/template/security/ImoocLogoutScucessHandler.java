package cj.springboot.security.template.security;

import cj.springboot.security.template.util.jwt.CJJWTUtil;
import cj.springboot.security.template.util.jwt.JwtUtil;
import cj.springboot.security.template.util.redis.CJRedisCache;
import cn.com.ns.cj.cjuniversalspringbootstarter.returnData.CJAjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
public class ImoocLogoutScucessHandler implements LogoutSuccessHandler {



    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    CJRedisCache cjRedisCache;

    Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("用户退出");

        String token = request.getHeader("token");
        String userid = CJJWTUtil.parseJWT(token).getSubject();
        //删除redis中的值
        cjRedisCache.deleteObject("templatelogin:"+userid);

        //如果用户配置退出页面，如果没有配置
        /*String propertyUrl = securityProperties.getBrowser().getSignOutTo();
        if(StringUtils.isBlank(propertyUrl)){*/
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(CJAjaxResult.success("CJ正常退出")));
//        }else{
//            response.sendRedirect(propertyUrl);
//        }

    }
}
