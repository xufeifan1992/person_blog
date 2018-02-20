package com.feifan.spring.boot.thymeleaf.blog.vo;

/**
 * 后台管理菜单 
 * @author xufei
 *
 */
public class Menu {
	
	private String name ;
	
	private String url ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	
}
