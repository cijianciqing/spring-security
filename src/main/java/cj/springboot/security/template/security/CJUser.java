package com.ns.cjcq.security.crud.domain;


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CJUser implements   UserDetails {

    private Long id;

    private String username;
    private String showname;
    private String password;
    private String telephoneNo;
    private String email;
    // 表示帐号是否未过期
    private Boolean isAccountNonExpired = Boolean.TRUE;
    //表示帐号是否未锁定
    private Boolean isAccountNonLocked = Boolean.TRUE;
    //表示登录凭据是否未过期
    private Boolean isCredentialsNonExpired = Boolean.TRUE;
    //表示账户是否被禁用
    private Boolean isEnabled = Boolean.TRUE;



    /*
     * UserDetails相关接口--开始
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }


}

