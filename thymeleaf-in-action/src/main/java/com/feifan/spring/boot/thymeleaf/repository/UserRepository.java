package com.feifan.spring.boot.thymeleaf.repository;

import java.util.List;

import com.feifan.spring.boot.thymeleaf.domain.User;

/**
 * User Repository 接口
 * add by xufeifan 2018-01-06
 * @author xufei
 *
 */
public interface UserRepository {
	
	/**
	 * 创建或者修改用户
	 */
	User saveOrUpdateUser(User user);
	
	
	/**
	 * 删除用户
	 */
	void deleteUser(Long id);
	
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> listUsers();
}
