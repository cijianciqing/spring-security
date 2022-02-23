package cj.springboot.security.template.util.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Slf4j
@Component
public class CJErrorAttribute extends DefaultErrorAttributes {
    /*
    * 在原有的基础上，添加自定义的内容
    * */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Object cjExceptionHandlerMessage = webRequest.getAttribute("cjExceptionHandlerMessage", 0);
        errorAttributes.put("cjExceptionHandlerMessage",cjExceptionHandlerMessage);
        return errorAttributes;
    }


}
