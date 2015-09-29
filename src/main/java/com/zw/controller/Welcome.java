package com.zw.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zw.service.UserService;

@Controller
public class Welcome {
	
	private static final Logger logger = LogManager.getLogger(Welcome.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request){
              ModelAndView mv =new ModelAndView();
              String userName = request.getParameter("userName");
              logger.info("userName=[" + userName+"]");
              String user = userService.getUserByName(userName);
              mv.addObject("userName", user);
              mv.setViewName("hello");

              return mv;

    }
	
	@RequestMapping("/chatroom")
    public ModelAndView chatroom(){
              ModelAndView mv =new ModelAndView();
              mv.setViewName("websocket");

              return mv;

    }

}
