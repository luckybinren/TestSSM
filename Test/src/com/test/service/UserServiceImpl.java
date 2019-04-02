package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserMapper;
import com.test.entity.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userDao;
	User user=new User();
	public boolean check(User user) {
		User userNew=userDao.checkUser(user.getName());
		if(userNew==null){
			return false;
		}
		if(user.getPassword().equals(userNew.getPassword())){
			return true;
		}
		return false;
	}

}
