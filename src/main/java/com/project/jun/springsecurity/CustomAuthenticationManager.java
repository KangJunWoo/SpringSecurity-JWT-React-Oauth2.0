package com.project.jun.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.jun.service.UserService;

public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    UserService userService;
    
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
    	System.out.println("CustomAuthenticationManager시작");
    	System.out.println("CustomAuthenticationManager의 auth.getName()-->"+auth.getName());
        UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());
        System.out.println("CustomAuthenticationManager가 받아온 userDetail:"+userDetails);
        // 각종 처리를 구현
        // 비번이 일치하는지
        // 아이디로 회원을 조회 했을 때 존재하는 회원인지
        // 기타 등등과 적절한 예외 처리 
        return new UsernamePasswordAuthenticationToken(userDetails
                , userDetails.getPassword()
                , userDetails.getAuthorities());
    }
}
