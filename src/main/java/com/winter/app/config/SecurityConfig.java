package com.winter.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	WebSecurityCustomizer customizer() {
		
		return web -> {
			web
				.ignoring()
					.requestMatchers("/css/**")
					.requestMatchers("/images/**","/img/**")
					.requestMatchers("/js/**","/vendor/**");
		};
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		security
			.cors((cors)->{cors.disable();})
			.csrf((csrf)->{csrf.disable();})
			.authorizeHttpRequests((auth)->{
				auth
					.requestMatchers("/notice/add","/notice/update","/notice/delete").hasRole("ADMIN")
					.requestMatchers("/product/add","/product/update","/product/delete").hasAnyRole("MANAGER","ADMIN")
					.requestMatchers("/product/**").authenticated()
					.requestMatchers("/users/mypage","/users/update","users/logout").authenticated()
					.anyRequest().permitAll();
			})
			.formLogin((form)->{
				form
					.loginPage("/users/login")
					.defaultSuccessUrl("/");
			})
			.logout((logout)->{
				logout
					.logoutUrl("/users/logout")
					.logoutSuccessUrl("/");
			})
			;
		return security.build();
	}
	
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
