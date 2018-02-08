package com.feifan.spring.boot.thymeleaf.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类 add by xufeifan 2018-02-07
 * 
 * @author xufei
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * 权限的控制
	 * add by xufeifan 2018-02-07
	 */
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("222");
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()//都可以访问
				.antMatchers("/users/**").hasRole("ADMIN")//需要相应得角色才可以访问
				.and()
				.formLogin()
				.loginPage("/login") //基于form表单登陆验证
				.failureUrl("/login-error");//自定义登陆页面
	}
	
	/**
	 * 认证信息管理
	 * add by xufeifan 2018-02-07
	 * @throws Exception 
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("111");
		auth.inMemoryAuthentication()
		.withUser("xufeifan").password("xu19921024").roles("ADMIN").and().withUser("user").password("123456").roles("ADMIN");
	}
}
