package com.feifan.spring.boot.blog.controller;

import java.util.List;

public class UserModels {
	List<TestModel> users;

	public List<TestModel> getUsers() {
		return users;
	}



	public void setUsers(List<TestModel> users) {
		this.users = users;
	}



	public UserModels() {
		super();
	}
	
}
