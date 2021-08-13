package com.project.jun.springsecurity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.jun.service.UserService;


@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers("/postinfo/**").hasRole("USER")
				.antMatchers("/userinfo/**", "/login", "/oauth/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.cors()
				.and()
				.httpBasic().disable()
				.formLogin().disable()
				.logout()
				.and()
				.addFilterBefore(new ServletFilter(), SecurityContextPersistenceFilter.class)
				.addFilter(new CustomAuthenticationFilter(customAuthenticationManager()))
				.addFilter(new CustomAuthorizationFilter(customAuthenticationManager(),userService));
	}

	@Bean
	public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
				customAuthenticationManager());
		return customAuthenticationFilter;
	}

	@Bean
	public CustomAuthenticationManager customAuthenticationManager() throws Exception {
		return new CustomAuthenticationManager();
	}
	
	@Bean
	public CustomAuthorizationFilter customAuthorizationFilter() throws Exception {
		CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter(customAuthenticationManager(), userService);
		return customAuthorizationFilter;
	}

	/*
	public CustomLoginSuccessHandler customLoginSuccessHandler() {
		String defaultTargetUrl = "/postinfo/selectall_postinfo";
		return new CustomLoginSuccessHandler(defaultTargetUrl);
	}
	*/
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4333"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "TOKEN_ID", "X-Requested-With", "Content-Type", "Content-Length", "Cache-Control"
				,"access_token", "token_type"));
		configuration.addExposedHeader("Authorization");
		configuration.addExposedHeader("access_token");
		//다른 도메인의 request header에 쿠키를 담아 요청하는 것을 허용 --> 근데 httpOnly라 http요청이 아닐 시에는 허용안됨(ex:javascript)
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}