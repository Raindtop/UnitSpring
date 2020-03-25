package com.raindrop.security;

import com.raindrop.core.Model.Account;
import com.raindrop.core.Model.MysqlDemo;
import com.raindrop.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MySQLService mySQLService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("username:" + s);
        Account account = new Account(MysqlDemo.builder().name("admin").age("17").birthday("2020-03-25").sex("mane").build());
        System.out.println(account.toString());

        return account;
    }
}
