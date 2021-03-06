package cj.springboot.security.template.security;


import cj.springboot.security.template.util.redis.CJRedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Component("rbacService")
public class CJRBACServiceImpl {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private CJRedisCache redisCache;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object principal = authentication.getPrincipal();



        boolean hasPermission = false;



        if (antPathMatcher.match("/cjsec/test2",request.getRequestURI())) {
            hasPermission = true;
        }
        log.info("cj ==>" + request.getRequestURI() + "==>has Permission!!!");

        //有可能是匿名用户,有则说明是认证过的？？？
        cjI1:
        if (principal instanceof UserDetails) {


            String username = ((UserDetails) principal).getUsername();

            //读取所有权限
//            List<CJResource> cjResources =  cjUserPermissionService.getUserResources((CJUser)principal);

            //超级管理员访问所有
//            if (username.equalsIgnoreCase(cjSpringSecurityProperty.getCjSuperAdminUsername())) {
            if (username.equalsIgnoreCase("SuperAdmin")) {
                hasPermission = true;
                break cjI1;
            }
            if (antPathMatcher.match("/cjsec/test2",request.getRequestURI())) {
                    hasPermission = true;
                }
            log.info("cj ==>" + username + "==>has Permission!!!");
//            for (CJResource cjResource : cjResources) {

//                if ((antPathMatcher.match(cjResource.getUrl(), request.getRequestURI()))
//                        && cjResource.getCjUrlType().getMessage().equalsIgnoreCase(request.getMethod())) {
//                    hasPermission = true;
//                    log.info("cj ==>" + username + "==>has Permission!!!");
//                    break;
//                }

//            }

        }
        return hasPermission;
    }
}
