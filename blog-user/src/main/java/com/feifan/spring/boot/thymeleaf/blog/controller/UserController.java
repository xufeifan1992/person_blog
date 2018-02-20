package com.feifan.spring.boot.thymeleaf.blog.controller;

import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.feifan.spring.boot.thymeleaf.blog.domain.User;
import com.feifan.spring.boot.thymeleaf.blog.service.UserService;
import com.feifan.spring.boot.thymeleaf.blog.util.ConstraintViolationExceptionHandler;
import com.feifan.spring.boot.thymeleaf.blog.vo.Response;

/**
 * User 控制器 add by xufeifan 2018-01-06
 * 
 * @author xufei
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(@RequestParam(value = "async" , required = false) boolean async ,
			@RequestParam(value = "pageIndex" , required = false , defaultValue = "0") int pageIndex ,
			@RequestParam(value = "pageSize" , required = false , defaultValue = "10") int pageSize , 
			@RequestParam(value = "name" ,required = false , defaultValue = "") String name,
			Model model
			){
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<User> page = userService.listUsersByNameLike(name, pageable);
		List<User> list = page.getContent();    // 当前所在页面数据列表
		
		model.addAttribute("page", page);
        model.addAttribute("userList", list);
		return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"users/list", "userModel", model);
	} 

	/**
	 * 获取创建表单页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null, null,null));
		return new ModelAndView("users/add", "userModel", model);
	}

	/**
	 * 保存或者修改用户
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Response> saveOrUpdateUser(User user) {
		try {
			userService.saveOrUpateUser(user);
		} catch (ConstraintViolationException e) {
			//处理失败
			return ResponseEntity.ok().body(new Response(false,ConstraintViolationExceptionHandler.getMessage(e)));
		}
		//处理成功
		return ResponseEntity.ok().body(new Response(true, "处理成功", user));
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
		try {
			userService.removeUser(id);
		} catch (ConstraintViolationException e) {
			//处理失败
			return ResponseEntity.ok().body(new Response(false,ConstraintViolationExceptionHandler.getMessage(e)));
		}
		//处理成功
		return ResponseEntity.ok().body(new Response(true, "处理成功"));
	}

	/**
	 * 获取修改用户的页面
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "edit/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/edit", "userModel", model);
	}

}
