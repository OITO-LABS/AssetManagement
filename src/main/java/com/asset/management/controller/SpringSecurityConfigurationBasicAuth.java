package com.asset.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.asset.management.service.UserLoginServiceImpl;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserLoginServiceImpl userLoginServiceImpl;

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		final StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		return firewall;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
		
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userLoginServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}


	// ...
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**", "/index", "/static/**", "/*.js", "/*.json", "/*.ico", "/oito-trv",
				"/config/appconfig.json")
		.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/oito-trv")
		.loginProcessingUrl("/api/login").usernameParameter("username").passwordParameter("password")
		// .permitAll()
		.defaultSuccessUrl("/oito-trv/home", true)
		.failureUrl("/oito-trv?login-error");

	}
}