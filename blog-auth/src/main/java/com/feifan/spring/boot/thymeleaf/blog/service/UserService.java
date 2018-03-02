package com.feifan.spring.boot.thymeleaf.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.feifan.spring.boot.thymeleaf.blog.domain.User;

/**
 * 用户服务接口
 * @author xufei
 *
 */
public interface UserService {
	 /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}
