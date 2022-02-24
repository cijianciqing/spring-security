package cj.springboot.security.template.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class CJLoginController {
    @RequestMapping(value = "/cjRequireLogin")
    public String cjAuthRequireLogin(){
        log.info("cj.springboot.security.template.controller.CJLoginController.cjAuthRequireLogin....");
        return "需要认证";
    }

}
