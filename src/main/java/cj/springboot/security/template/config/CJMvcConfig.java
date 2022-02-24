package cj.springboot.security.template.config;

import cj.springboot.security.template.config.servlet.CJTestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebMvc
@EnableScheduling
public class CJMvcConfig implements WebMvcConfigurer {

	/*
	* 注册自定义的Filter
	* */
	@Bean
	public FilterRegistrationBean timeFilter() {

		FilterRegistrationBean registrationan = new FilterRegistrationBean();

		CJTestFilter timeFilter = new CJTestFilter();

		registrationan.setFilter(timeFilter);


		List<String> urls = new ArrayList<>();

		urls.add("/*");

		registrationan.setUrlPatterns(urls);

		registrationan.setOrder(Integer.MIN_VALUE);
		return registrationan;

	}

	//不通过controller,直接跳转
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

/*
* 以下为测试
* */
		registry.addViewController ("/test01").setViewName("/test/test01");


		//		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/demo/ckeditor401").setViewName("demo/ckeditor4Demo01");
		registry.addViewController("/demo/dataTablesDemo").setViewName("demo/dataTableDemo_ServerSide");
		registry.addViewController("/demo/index").setViewName("demo/index");
		registry.addViewController("/imooc-signIn").setViewName("imooc-signIn");

/*
 * 以下为正式环境
 * */
//		首页
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
//		登录页面
		registry.addViewController("/auth/signIn").setViewName("auth/signIn");
//		session invalid
		registry.addViewController("/session/invalid").setViewName("session/invalid");

		registry.addViewController("/error/404").setViewName("error/404");
	}

	/*静态资源设置*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandler     是指你想在url请求的路径
		//addResourceLocations   是图片存放的真实路径,可以是classpath:,也可以是file:
		registry.addResourceHandler("/cjThirdStatic/**").addResourceLocations("classpath:/static/vendor/");
		registry.addResourceHandler("/node_modules/**").addResourceLocations("classpath:/static/node_modules/");
		registry.addResourceHandler("/sb2Static/**").addResourceLocations("classpath:/static/sb2/");
		registry.addResourceHandler("/icon/**").addResourceLocations("classpath:/static/icon/");
		registry.addResourceHandler("/cjStatic/**").addResourceLocations("classpath:/static/cjStatic/");

	}


	/*
	 * 全局CORS配置
	 *
	 * 暂时禁用
	 * */
/*	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("*")
				.allowedHeaders(CorsConfiguration.ALL)
				.allowedMethods(CorsConfiguration.ALL)
				.allowCredentials(true)
				.maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
	}*/



}
