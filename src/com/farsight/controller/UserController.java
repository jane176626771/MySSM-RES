package com.farsight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.farsight.entity.User;
import com.farsight.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request){
		List<User> userList = userService.findAll();
		request.setAttribute("userList", userList);
		return "/userList";
	}
	
	@RequestMapping("/preAdd.do")
	public String preAdd(){
		return "addUser";
	}
	
	@RequestMapping("/addUser.do")
	public String addUser(User user){
		userService.addUser(user);
		return "redirect:/user/list.do";//重定向
	}
	
	@RequestMapping("/delete.do")//处理js请求删除数据
	public String delete(User user){
		userService.deleteUser(user.getId());
		return "redirect:/user/list.do";
	}

	@RequestMapping("/delUser.do")//处理jquery请求删除数据
	public void delUser(int id,HttpServletRequest request,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(userService.deleteUser(id)){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value="/preUpdate.do")
	public ModelAndView preUpdate(Integer id){
		User user = userService.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("updateUser");
		return mv;
	}

	@RequestMapping(value="/updateUser.do")
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/user/list.do";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
