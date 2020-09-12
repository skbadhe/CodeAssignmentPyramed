/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shubhambadhe.CodeAssignmentPyramed.Login.Login;
import com.shubhambadhe.CodeAssignmentPyramed.Login.LoginService;
import com.shubhambadhe.CodeAssignmentPyramed.User.RegisterUser;
import com.shubhambadhe.CodeAssignmentPyramed.User.User;
import com.shubhambadhe.CodeAssignmentPyramed.User.UserMethods;

/**
 * @author Shubham
 *
 */
@RestController
public class ChitterController {
	
	private User LoggedInUser;
	
	@Autowired
	private UserMethods userService;
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	String register(@RequestBody RegisterUser regUser) {
		User user = new User();
		user.setUserID(regUser.getUserID());
		user.setUserName(regUser.getUserName());
		user.setFollowingIDs(regUser.getFollowingIDs());
		user.setFollowersID(regUser.getFollowersID());
		Login login = new Login();
		login.setUsername(regUser.getUserName());
		login.setPassword(regUser.getPassword());
		userService.addUser(user);
		loginService.addUser(login);
		return "registered";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	String login(@RequestBody Login loginInfo) {
		int check=-1;
		check = loginService.checkLogin(loginInfo);
		if(check==1) {
			LoggedInUser = userService.getUser(loginInfo.getUsername());
			return "Logged In!";
		}else if(check==0) {
			return "Login Failed";
		}
		return "User Doesnot Exist!";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	String logout() {
		if(LoggedInUser == null) {
			return "Already Logged Out!";
		}else {
		return "Logged Out!";
		}
	}

	@RequestMapping(value = "/postChit", method = RequestMethod.POST)
	String postChit() {
		return "postedChit";
	}

	@RequestMapping(value = "/follow", method = RequestMethod.POST)
	String followUser() {
		return "followed";
	}

	@RequestMapping(value = "/getChit", method = RequestMethod.GET)
	String GetFollowedChits() {
		return "got All Chits";
	}

}
