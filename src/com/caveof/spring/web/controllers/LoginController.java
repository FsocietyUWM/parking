package com.caveof.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.CennikPrices;
import com.caveof.spring.web.dao.FormValidationGroup;
import com.caveof.spring.web.dao.PasswordOldNew;
import com.caveof.spring.web.dao.Offer;
import com.caveof.spring.web.dao.User;
import com.caveof.spring.web.dao.UserDetails;
import com.caveof.spring.web.service.UsersService;

@Controller
public class LoginController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//////////////////////////////////////////////////////////
	

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("users", users);
		return "admin";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Validated(FormValidationGroup.class) User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		user.getUserDetails().setUsername(user.getUsername());
		
		if(usersService.userExists(user.getUsername())) {
			result.rejectValue("username", "DuplicatKey.user.username");
			return "newaccount";
		}
		usersService.createUser(user);
		
		/*
		try {
			usersService.createUser(user);
		} catch (DuplicateKeyException ex) {
			result.rejectValue("username", "DuplicatKey.user.username");
			return "newaccount";
		}
		*/
		
		return "accountcreated";
	}
	
	@RequestMapping("/changepw")
	public String changePassword(Model model) {
		
		PasswordOldNew passwordOldNew = new PasswordOldNew();
		model.addAttribute("passwordOldNew", passwordOldNew);
		
		return "changepw";
	}
	
	@RequestMapping("/updatepw")
	public String updatePassword(Model model, PasswordOldNew passwordOldNew, BindingResult result,  Principal principal) {
		
		if (result.hasErrors()) {
			return "changepw";
		}
		
		String username = principal.getName();
		User authUser = usersService.getUser(username);
		
		String oldPassword = passwordOldNew.getOldPassword();
		if (passwordEncoder.matches(oldPassword, authUser.getPassword())) {
			
			authUser.setPassword(passwordOldNew.getNewPassword());
			usersService.changeUserPassword(authUser);
			
			boolean changeStatus = true;
			model.addAttribute("changeStatus", changeStatus);
			return "pwupdated";
		} else {
			
			boolean changeStatus = false;
			model.addAttribute("changeStatus", changeStatus);
			return "pwupdated";
		}
	}
	
	@RequestMapping("/userdetails")
	public String showUserDetails(Model model, Principal principal) {
		
		String username = principal.getName();

		User authUser = usersService.getUser(username);
		UserDetails userDetails = authUser.getUserDetails();
		model.addAttribute("userDetails", userDetails);

		return "userdetails";
	}
	
	@RequestMapping("/updateuserdetails")
	public String updateUserDetails(Principal principal, UserDetails userDetails, BindingResult result) {

		if (result.hasErrors()) {
			return "userdetails";
		}
		
		String username = principal.getName();
		User authUser = usersService.getUser(username);
		authUser.setUserDetails(userDetails);

		usersService.saveOrUpdate(authUser);
			
		return "userdetailsupdated";
	}
	
	
}
