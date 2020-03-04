package com.learning.spring_mvc_security_jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	//this function is used to add users -> in memory or db
	@Autowired
	private DataSource securityDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//UserBuilder users = User.withDefaultPasswordEncoder();
		//auth.inMemoryAuthentication()
			//	.withUser(users.username("kbhatt23").password("Suarez@23").roles("EMPLOYEE"))
				//.withUser(users.username("kanha").password("radha@123").roles("ADMIN"))
				//.withUser(users.username("ganesh").password("jaimatagauri").roles("MANAGER"))
				//;
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	//this funtion is used to add url and its use if authentication is needed or not
	//allow login page for all users 	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//here we can configure things declaratively
		//each config is sperateored by and function
		http.authorizeRequests()
		//allowing for landing page
				.antMatchers("/")
				.permitAll()
				.antMatchers("/security-system/managers/**")
				.hasRole("MANAGER")
				.antMatchers("/security-system/admins/**")
				.hasRole("ADMIN")
				//configuring authorization
				//for all resources check for validation
				.anyRequest()
				.authenticated()
				.and()
				//new configuration
				.formLogin()
				//conmfigurations for logins
				.loginPage("/showLogin")//showLogin will be request mapping url -> getmapping shiud return jsp for login
				.loginProcessingUrl("/validateUser")//this is postmapping url on login form submission page
				.permitAll()
				//login page shud be open for all
				.and()
				//opening ogout page for all
				//default url for logout is /logut and method is post , GET is blocked
				.logout()
				.permitAll()
				
				//exception handling part
				.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied")
				;
				
	}
	
	

}
