/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhambadhe.CodeAssignmentPyramed.Repository.UserRepository;

/**
 * @author Shubham
 *
 */
@Service
public class UserMethods {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}

	public User getUser(String username) {
		User retUser = null;
		List<User> allUsers = (List<User>) userRepository.findAll();
		for(User user:allUsers) {
			if(user.getUserName().equals(username))
				retUser = user;
				break;
		}
		return retUser;
	}

}
