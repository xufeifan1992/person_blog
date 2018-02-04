package com.feifan.spring.boot.thymeleaf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.feifan.spring.boot.thymeleaf.domain.User;

/**
 * User Repository 接口
 * add by xufeifan 2018-01-06
 * @author xufei
 *
 */
public interface UserRepository extends CrudRepository<User, Long>{
	
}
