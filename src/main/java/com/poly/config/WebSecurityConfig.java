package com.poly.config;

import com.poly.common.RoleConst;
import com.poly.jwt.JwtAuthenticationFilter;
import com.poly.service.impl.CustomUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserServiceImpl customUserService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		/*
		  	Su dung doan code nay de chan cac request tuong ung voi role ADMIN
		  	Khi xay dung chuc nang cho phia admin thi dung doan code nay de khong cho
		     cac user thong thuong duoc goi api admin va truy cap trang admin
		 
		 http.authorizeRequests().antMatchers("/admin/**").hasAuthority(RoleConst.ROLE_ADMIN);
		 */
		http.authorizeRequests().antMatchers("/admin/**").hasAuthority(RoleConst.ROLE_ADMIN);
		http.authorizeRequests().and().rememberMe()
					.tokenRepository(this.persistentTokenRepository())
					.tokenValiditySeconds(30*60);
		http.cors()
				.and().authorizeRequests()
				.antMatchers("/admin/**", "/home","/index", "/login", "/logout", "/sanpham/**", "/api/**","/cart/**", "/register","/registration").permitAll() // Cho phep tat ca truy cap link nay
				.anyRequest().authenticated(); // Cac link con lai thi phai xac thuc
	
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/foodshop/**", "/assets/**","/css/**", "/fonts/**", "/img/**", "/js/**","/script/**");
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
}
