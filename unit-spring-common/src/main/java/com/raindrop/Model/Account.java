package com.raindrop.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

public class Account extends MysqlDemo implements UserDetails {
    List<GrantedAuthority> grantedAuthorities;

    public Account(MysqlDemo mysqlDemo){
        super.setName(mysqlDemo.getName());
        super.setAge(mysqlDemo.getAge());
        super.setPassword(new BCryptPasswordEncoder().encode("123456"));
        super.setUuid(mysqlDemo.getUuid());
        super.setSex("man");
        this.grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_mysql,ROLE_hello");

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "grantedAuthorities=" + grantedAuthorities +
                '}';
    }
}
