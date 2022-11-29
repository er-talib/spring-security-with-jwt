package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.jwt.service.impl.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		        .csrf()
		        .disable()
//		        .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		        .and()
				.authorizeHttpRequests()
				.antMatchers("/home/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/user/**").permitAll()
				.antMatchers("/vehical/**").hasRole("ADMIN")
				.antMatchers("/vehical/details/getAll").hasRole("NORMAL")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/dologin")
				.defaultSuccessUrl("/home/success");
//		     .httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Talib").password(this.passwordEncoder().encode("Talib@123")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("Amir").password(this.passwordEncoder().encode("12345")).roles("NORMAL");

		auth.userDetailsService(customUserDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
