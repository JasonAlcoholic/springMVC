package com.zw.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zw.dao.UserDao;
import com.zw.entity.User;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UserService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private AutoService autoService;

	public String getAllUsers(){
		List<User> userList = new ArrayList<User>();
		String hsql="from users";
		userList = autoService.findByHql(hsql);
		JSONArray jsonArray = JSONArray.fromObject(userList);
		String json = jsonArray.toString();
		return json;
	}
	
	public String getUserByName(String name){
		List<User> userList = new ArrayList<User>();
		String hsql="from user where name = '" + name + "'";
		userList = autoService.findByHql(hsql);
		logger.info("List size: " + userList.size());
		JSONArray jsonArray = JSONArray.fromObject(userList);
		String json = jsonArray.toString();
		return json;
	}
	

}
