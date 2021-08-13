package com.project.jun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.jun.domain.PostInfo;

@RestController
@RequestMapping("/oauth")
public class OauthController {
	
	@PostMapping(value="/kakaoGetToken")
	public String kakaoGetToken(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("/kakaoGetToken시작");
		String code=map.get("code");
		System.out.println(code);
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "37ad3e70908865af97d7b0a7d0e23468");
		params.add("redirect_uri", "http://localhost:4333/oauth");
		params.add("code", code);
		System.out.println("headers"+headers);
		System.out.println("params:"+params);
		
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
				new HttpEntity<>(params, headers);
		System.out.println("kakaoTokenRequest"+kakaoTokenRequest);
		
		ResponseEntity<String> tokenResponse = rt.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		System.out.println(tokenResponse);
		String tokenBody=tokenResponse.getBody();
		return tokenBody;
	}
	
}
