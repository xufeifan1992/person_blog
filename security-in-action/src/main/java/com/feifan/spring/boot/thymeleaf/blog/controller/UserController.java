package com.feifan.spring.boot.thymeleaf.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.feifan.spring.boot.thymeleaf.blog.domain.User;
import com.feifan.spring.boot.thymeleaf.blog.repository.UserRepository;

/**
 * User 控制器
 * add by xufeifan  2018-01-06
 * @author xufei
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list( Model model , @ModelAttribute("qqq") String qqq){
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list","userModel",model);
	} 
	
	/**
	 * 根据id查询用户
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id , Model model){
		
		User user  = userRepository.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		
		return new ModelAndView("users/view","userModel",model);
	}
	/**
	 * 获取创建表单页面
	 * @param model
	 * @return
	 */
	@GetMapping({"/form"})
	public ModelAndView createForm(Model model){
		
		model.addAttribute("user", new User(null,null,null));
		model.addAttribute("title", "创建用户");
		
		return new ModelAndView("users/form","userModel",model);
	} 
	
	/**
	 * 保存或者修改用户
	 * @param model
	 * @return
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user , RedirectAttributes attr){
		userRepository.save(user);
		attr.addFlashAttribute("qqq","123");
		//重定向到list页面
		return new ModelAndView("redirect:/users");
	} 
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id){
		userRepository.delete(id);;
		//重定向到list页面
		return new ModelAndView("redirect:/users");
	} 
	/**
	 * 获取修改用户的页面
	 * @param id
	 * @return
	 */
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id , Model model){
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		model.addAttribute("title","修改用户");
		return new ModelAndView("users/form" , "userModel" , model);
	} 
	
	
}
