package com.feifan.spring.boot.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello Controller
 * add by xufeifan-lhq 2017-12-23
 * @author xufei
 *
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(@RequestBody TestModel model){
		
		
		return "Hello World";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "id", required = false) String id ,
			@RequestParam(value = "name", required = false) String name
			){
		
		
		return "Hello World";
	}
	@RequestMapping("/hello3")
	public String hello3(TestModel model){
		
		
		return "Hello World";
	}
	
	@RequestMapping("/hello5")
	public String hello5(@RequestParam(value = "id", required = false) String [] id){
		
		
		return "Hello World";
	}
	
	@RequestMapping("/hello6")
	public String hello6(@RequestBody Map<String, Object> param){
		
		
		return "Hello World";
	}
	@RequestMapping("/hello7")
	public String hello7( UserModels users){
		
		
		return "Hello World";
	}
	@RequestMapping("/hello8")
	public String hello8(@RequestBody List<TestModel> list){
		
		
		return "Hello World";
	}
}
