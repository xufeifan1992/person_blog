package com.feifan.spring.boot.thymeleaf.domain;

/**
 * 用户实体
 * add by 2018-01-05
 * @author xufei
 *
 */
public class User {
	
	//实体的唯一标识
	private Long id;
	
	//用户名称
	private String name;
	
	//用户邮箱
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	 
}
