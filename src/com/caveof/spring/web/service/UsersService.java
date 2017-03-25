package com.caveof.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

}
