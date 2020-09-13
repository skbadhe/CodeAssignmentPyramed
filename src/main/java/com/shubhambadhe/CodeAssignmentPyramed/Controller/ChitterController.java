/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Controller;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shubhambadhe.CodeAssignmentPyramed.Chit.Chit;
import com.shubhambadhe.CodeAssignmentPyramed.Chit.ChitService;
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
	
	public static User LoggedInUser;
	
	@Autowired
	private UserMethods userService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ChitService chitservice;

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
	String postChit(@RequestBody Chit chit) {
		String response = "Log in first";
		if(!(LoggedInUser==null)) {
			chit.setUsername(LoggedInUser.getUserName());
			Time time = new Time(0);
			chit.setTime(time);
			chitservice.postChit(chit);
			response = "Posted Successfully";
		}
		return response;
	}

	@RequestMapping(value = "/follow", method = RequestMethod.POST)
	String followUser(@RequestBody User user) {
		String response = "Log in first";
		String followUserName = user.getUserName();
		if(!(LoggedInUser==null)) {
			userService.followUser(followUserName);
			response = "followed";
		}
		return response;
	}

	@RequestMapping(value = "/getChit", method = RequestMethod.GET)
	HashMap<String, List<Chit>> GetFollowedChits() {
		HashMap<String, List<Chit>> response = new HashMap<>();
		if(!(LoggedInUser==null)) {
			HashMap<String, List<Chit>> all_chits = chitservice.getChits(LoggedInUser.getUserName());
			response = all_chits;;
		}
		return response;
	}

}
