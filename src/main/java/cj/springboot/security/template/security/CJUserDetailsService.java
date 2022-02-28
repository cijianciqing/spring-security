package cj.springboot.security.template.security;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/*
* 用于登录用户认证、授权
* */
@Slf4j
@Component("myUserDetailsService")
public class CJUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("cj.springboot.security.template.security.CJUserDetailsService.loadUserByUsername 登录用户名："+username);
        CJUser cjUser = new CJUser();
        cjUser.setId(666L);
        cjUser.setUsername("u1");
        cjUser.setPassword(passwordEncoder.encode("123"));
        return  cjUser;

    }
}
