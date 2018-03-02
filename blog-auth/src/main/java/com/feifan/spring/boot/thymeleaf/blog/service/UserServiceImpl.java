package com.feifan.spring.boot.thymeleaf.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.feifan.spring.boot.thymeleaf.blog.domain.User;
import com.feifan.spring.boot.thymeleaf.blog.repository.UserRepository;

/**
 * 用户服务接口实现
 * @author xufei
 *
 */
@Service
public class UserServiceImpl implements UserService , UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User saveOrUpateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void removeUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		//模糊查询 
		name = "%" + name + "%";
		return userRepository.findByNameLike(name, pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

}
