package com.project.jun.springsecurity;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.jun.domain.UserInfo;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
		super.setAuthenticationManager(customAuthenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// 1.RequestBody확인하는 방법
		// request.getInputStream().toString() --> request.body객체 확인
		try {
			// ObjectMapper로 확인(자동 매핑시켜줌 @ModelAttribute처럼)
			ObjectMapper om = new ObjectMapper();
			UserInfo userInfo = om.readValue(request.getInputStream(), UserInfo.class);
			System.out.println(userInfo);
			System.out.println("CustomUsernamePasswordAuthenticationFilter시작");
			System.out.println("Token만들기 전 username 확인:" + userInfo.getUsername());
			System.out.println("Token만들기 전 password 확인:" + userInfo.getPassword());
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userInfo.getUsername(),
					userInfo.getPassword());
			System.out.println("CustomAuthenticationManager시작 전 token확인:" + auth);
			Authentication authentication = this.getAuthenticationManager().authenticate(auth);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("authentication객체 받아와서 SecurityContextHolder에 들어갔는지 확인 --> "
					+ SecurityContextHolder.getContext().getAuthentication());
			// BufferdReader로 확인
			// BufferedReader br = request.getReader();
			// String input =null;
			// while((input=br.readLine())!=null) {
			// System.out.println(input);
			// }
			
			// authentication 객체를 session영역에 저장해야함 --> 그 방법이 authentication를 리턴하면 security에서 알아서 저장함
			// 이렇게 저장하면 security가 알아서 권한관리를 해줌 --> 편함
			
			return authentication;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("로그인성공(인증성공) --> successfulauthentication시작");
		UserInfo userInfo= (UserInfo)authResult.getPrincipal();
		System.out.println("Authenticationfilter:"+userInfo);
		System.out.println("===============jwt 생성=============");
		String jwtToken = JWT.create()
				.withSubject("juns토큰")
				.withExpiresAt(new Date(System.currentTimeMillis()+(60000*10)))
				.withClaim("username", userInfo.getUsername())
				.sign(Algorithm.HMAC512("juns"));
		System.out.println("===============jwt 생성 끝=============");
		response.addHeader("Authorization", "Bearer "+jwtToken);
	}
}
