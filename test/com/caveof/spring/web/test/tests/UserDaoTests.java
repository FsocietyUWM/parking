package com.caveof.spring.web.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/caveof/spring/web/config/dao-context.xml",
		"classpath:com/caveof/spring/web/config/security-context.xml",
		"classpath:com/caveof/spring/web/test/config/datasource.xml", })

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	private User user1 = new User("Yoko", "facebook", "yoko@gmail.com", true, "ROLE_USER");
	private User user2 = new User("Kallen", "facebook", "kallen@gmail.com", true, "ROLE_USER");
	private User user3 = new User("Makise", "facebook", "makise@gmail.com", true, "ROLE_USER");
	private User user4 = new User("Yagami", "facebook", "yagami@gmail.com", true, "ROLE_USER");
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateRetrieve() {
		
		usersDao.createUser(user1);
		List<User> users1 = usersDao.getAllUsers();
		assertEquals("One user should be created and retrieved.", 1, users1.size());
		assertEquals("Inserted user should match retrieved.", user1, users1.get(0));
		
		usersDao.createUser(user2);
		usersDao.createUser(user3);
		usersDao.createUser(user4);
		List<User> users2 = usersDao.getAllUsers();
		assertEquals("Should be four inserted users.", 4, users2.size());
	}
	
	@Test
	public void testExists() {
		usersDao.createUser(user1);
		usersDao.createUser(user2);
		usersDao.createUser(user3);
		assertTrue("User should exist.", usersDao.userExists(user2.getUsername()));
		assertFalse("User should not exist.", usersDao.userExists("dsdsdds"));
	}
	
}
