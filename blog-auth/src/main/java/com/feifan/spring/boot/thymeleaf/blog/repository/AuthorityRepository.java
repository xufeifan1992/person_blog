package com.feifan.spring.boot.thymeleaf.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feifan.spring.boot.thymeleaf.blog.domain.Authority;
/**
 * anthority仓库
 * 
 * @author xufei
 *
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
