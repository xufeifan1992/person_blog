package com.feifan.spring.boot.blog.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
	/**
	 *传递json参数
	 */
	@Test
	public void testHello() throws Exception {
		String param = "{\"id\":1, \"name\":\"zhang\"}"; 
			mocMvc.perform(MockMvcRequestBuilders.post("/hello").contentType(MediaType.APPLICATION_JSON)
					.content(param).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Hello World")))
			.andDo((MockMvcResultHandlers.print()));
			
	}
	/**
	 * 传递字符串参数
	 * @throws Exception
	 */
	@Test
	public void testHello2() throws Exception {
		mocMvc.perform((get("/hello2?id=1&name=xufeifan")))//.param("id", "1").param("name", "xufeifan")))
         .andExpect(status().isOk()).andDo(print())
	                .andExpect(content().string(equalTo("Hello World")));
		
	}
	
	/**
	 * 传递字符串参数
	 * @throws Exception
	 */
	@Test
	public void testHello3() throws Exception {
		mocMvc.perform((get("/hello3?id=1&name=xufeifan")))//.param("id", "1").param("name", "xufeifan")))
         .andExpect(status().isOk()).andDo(print())
	                .andExpect(content().string(equalTo("Hello World")));
		
	}
	
	/**
	 * 传递字符串参数
	 * @throws Exception
	 */
	@Test
	public void testHello5() throws Exception {
		mocMvc.perform((get("/hello5?id=1&id=2")))//.param("id", "1").param("name", "xufeifan")))
         .andExpect(status().isOk()).andDo(print())
	                .andExpect(content().string(equalTo("Hello World")));
		
	}
	/**
	 *传递json参数
	 */
	@Test
	public void testHello6() throws Exception {
		String param = "{\"id\":1, \"name\":\"zhang\"}"; 
			mocMvc.perform(MockMvcRequestBuilders.post("/hello6").contentType(MediaType.APPLICATION_JSON)
					.content(param).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Hello World")))
			.andDo((MockMvcResultHandlers.print()));
			
	}
	
	/**
	 * 传递字符串参数
	 * @throws Exception
	 */
	@Test
	public void testHello7() throws Exception {
		mocMvc.perform((get("/hello7?users[0].id=1&users[1].id=2&users[0].name=123&users[1].name=321")))
         .andExpect(status().isOk()).andDo(print())
	                .andExpect(content().string(equalTo("Hello World")));
		
	}
	
	/**
	 *传递json参数
	 */
	

}
