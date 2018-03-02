package com.feifan.spring.boot.thymeleaf.blog.service;

import com.feifan.spring.boot.thymeleaf.blog.domain.Authority;

/**
 * 服务接口
 * @author xufei
 *
 */
public interface AuthorityService {
	/**
	 * 根据ID查询Authority
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Long id);
}
