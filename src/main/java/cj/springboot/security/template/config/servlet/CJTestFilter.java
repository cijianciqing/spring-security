package cj.springboot.security.template.config.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class CJTestFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:" + (new Date().getTime() - start));
        System.out.println("time filter finish");
    }


    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
