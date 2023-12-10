package com.poly.service.impl;


import com.poly.entity.Accounts;
import com.poly.jwt.CustomUser;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Accounts user = accountService.getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        try {
            List<GrantedAuthority> grantList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName());
            grantList.add(authority);
            return new CustomUser(user, grantList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
