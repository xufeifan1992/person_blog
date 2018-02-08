package com.feifan.spring.boot.thymeleaf.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户实体
 * add by 2018-01-05
 * @author xufei
 *
 */
@Entity  //实体
public class User {
	
	//实体的唯一标识  
	@Id  //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增策略
	private Long id;
	
	//用户名称
	private String name;
	
	//用户邮箱
	private String email;
	
	
	
	protected User() { //无参构造函数；设为protected 防止直接使用
	}
	
	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}



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
	
	@Override
	 public String toString() {
	        return String.format(
	                "User[id=%d, name='%s', emial='%s']",
	                id, name,email );
	    }
	 
}
