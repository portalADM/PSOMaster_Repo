/************************************************************************************************************
 * Class Name :  UserDetailsService.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Dec 3, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.Authority;
import com.zig.pso.rest.bean.UserMaster;
import com.zig.pso.service.IUserService;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService 
{
    static final Logger logger = Logger.getLogger(UserDetailsService.class);

    @Autowired
    private IUserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        UserMaster user = userService.getUserDetailsByUserName(login);
        if (user == null) 
        {
            PSOLoggerSrv.printERROR(logger, "User " + login + " was not found in the database");
            throw new UsernameNotFoundException("User " + login + " was not found in the database");
        } 

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmpId(), user.getPassword(),
                grantedAuthorities);
    }
}
