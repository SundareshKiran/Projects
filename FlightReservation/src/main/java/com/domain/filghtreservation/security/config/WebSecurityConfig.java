package com.domain.filghtreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(HttpSecurity http) {
		try {
			http.authorizeRequests()
					.antMatchers("/showregister", "/","/index.html", "/registerUser", "/login", "/showlogin", "/login/*")
					.permitAll().antMatchers("/admin/showAddFlight").hasAuthority("ADMIN").anyRequest().authenticated()
					.and().csrf().disable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
