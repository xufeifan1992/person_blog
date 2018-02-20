package com.feifan.spring.boot.thymeleaf.blog.vo;


/**
 * 返回对象封装
 * @author xufei
 *
 */
public class Response {
	
	private boolean success ;  	//处理是否成功
	
	private String message ;	//处理得消息提示
	
	private Object body ;		//返回的数据 
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public Response(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public Response(boolean success, String message, Object body) {
		super();
		this.success = success;
		this.message = message;
		this.body = body;
	}
	
	
}
