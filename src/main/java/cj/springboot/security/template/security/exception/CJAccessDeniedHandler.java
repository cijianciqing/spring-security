package cj.springboot.security.template.security.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
public class CJAccessDeniedHandler  implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info(accessDeniedException.getMessage());
        response.setStatus(403);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("CJ权限不足: " + accessDeniedException.getMessage());
    }
}
