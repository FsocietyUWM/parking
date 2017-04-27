package com.caveof.spring.web.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.UserDetails;
import com.caveof.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	//////////////////////////////////////////////////////////
	

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	public User getUser(String username) {
		return usersDao.getUser(username);
	}
	
	public void createUser(User user) {
		usersDao.createUser(user);
	}

	public boolean userExists(String username) {
		return usersDao.userExists(username);
	}
	
	public void changeUserPassword(User user) {
		usersDao.changeUserPassword(user);
	}
	
	public void saveOrUpdate(User user) {
		usersDao.saveOrUpdate(user);
	}

}
