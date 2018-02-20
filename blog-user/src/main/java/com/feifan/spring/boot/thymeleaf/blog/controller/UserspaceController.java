package com.feifan.spring.boot.thymeleaf.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页控制器
 * @author xufei
 *
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {
	
	@GetMapping("/{userName}")
	public String userSpace(@PathVariable("userName") String userName) {
		System.out.println("userName" + userName);
		return "/userspace/u";
	}
 
	@GetMapping("/{userName}/blogs")
	public String listBlogsByOrder(@PathVariable("userName") String userName,
			@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="category",required=false ) Long category,
			@RequestParam(value="keyword",required=false ) String keyword) {
		
		if (category != null) {
			
			System.out.print("category:" +category );
			System.out.print("selflink:" + "redirect:/u/"+ userName +"/blogs?category="+category);
			return "/userspace/u";
			
		} else if (keyword != null && keyword.isEmpty() == false) {
			
			System.out.print("keyword:" +keyword );
			System.out.print("selflink:" + "redirect:/u/"+ userName +"/blogs?keyword="+keyword);
			return "/userspace/u";
		}  
		
		System.out.print("order:" +order);
		System.out.print("selflink:" + "redirect:/u/"+ userName +"/blogs?order="+order);
		return "/userspace/u";
	}
	
	@GetMapping("/{userName}/blogs/{id}")
	public String listBlogsByOrder(@PathVariable("id") Long id) {
		 
		System.out.print("blogId:" + id);
		return "/userspace/blog";
	}
	
	
	@GetMapping("/{userName}/blogs/edit")
	public String editBlog() {
 
		return "/userspace/blogedit";
	}
}
