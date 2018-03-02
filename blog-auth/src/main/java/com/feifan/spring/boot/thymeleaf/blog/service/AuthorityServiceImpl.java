package com.feifan.spring.boot.thymeleaf.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feifan.spring.boot.thymeleaf.blog.domain.Authority;
import com.feifan.spring.boot.thymeleaf.blog.repository.AuthorityRepository;
/**
 * 服务接口实现
 * @author xufei
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Long id) {
		
		return authorityRepository.findOne(id);
	}

}
