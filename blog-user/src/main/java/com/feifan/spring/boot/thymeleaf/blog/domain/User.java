package com.feifan.spring.boot.thymeleaf.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
	
	//用户姓名
	@NotEmpty(message = "姓名不允许为空")
	@Size(min = 2 , max = 20)
	@Column(nullable = false , length = 20)   // 映射数据库字段  值不允许为空  长度为20
	private String name;
	
	//用户邮箱
	@NotEmpty(message = "用户邮箱不允许为空")
	@Size(max = 50)
	@Email(message = "邮箱格式不正确")           //验证邮箱格式
	@Column(nullable = false , length = 50 , unique = true)
	private String email;
	
	//用户名
	@NotEmpty(message = "用户名不允许为空")
	@Size(min = 3 , max = 20)
	@Column(nullable = false , length = 20 , unique = true)
	private String username;             	  //用户账号，登陆得唯一标识
	
	//用户密码
	@NotEmpty(message = "密码不允许为空")
	@Size(max = 100)
	@Column(nullable = false , length = 20 )
	private String password;  				  //登陆密码
	
	//用户头像信息
	@Column(length = 200)
	private String avatar; // 头像图片地址
	
	protected User() { //无参构造函数；设为protected 防止直接使用
	}
	
	public User(Long id, String name,String username, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	 public String toString() {
	        return String.format(
	                "User[id=%d, name='%s', username='%s' ,emial='%s']",
	                id, name, username ,email );
	    }
	 
}
