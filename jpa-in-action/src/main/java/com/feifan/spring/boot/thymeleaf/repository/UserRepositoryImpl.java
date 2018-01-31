package com.feifan.spring.boot.thymeleaf.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.feifan.spring.boot.thymeleaf.domain.User;

/**
 * User Repository
 * add by xufeifan 2018-01-06 
 * @author xufei
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	/**
	 * 计数器
	 */
	private static AtomicLong counter = new AtomicLong();
	
	/**
	 * 存储用户的容器
	 */
	private final ConcurrentMap<Long,User> userMap =  new ConcurrentHashMap<>();
	
	@Override
	public User saveOrUpdateUser(User user) {
		Long id  = user.getId();
		if(id == null){
			//用户不存在
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		this.userMap.remove(id);

	}

	@Override
	public User getUserById(Long id) {
		
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUsers() {
		
		return new ArrayList<User>(userMap.values());
	}

}
