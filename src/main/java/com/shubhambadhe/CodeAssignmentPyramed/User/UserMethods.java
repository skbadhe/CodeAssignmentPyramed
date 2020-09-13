/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhambadhe.CodeAssignmentPyramed.Controller.ChitterController;
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
		User retUser = new User();
		List<User> allUsers = (List<User>) userRepository.findAll();
		for (User user : allUsers) {
			String tempusername = user.getUserName();
			if (tempusername.equals(username)) {
				retUser = user;
				return retUser;
			}
		}
		return retUser;
	}

	public void followUser(String followUserName) {
		User toFollowUser = getUser(followUserName);
		User followerUser = ChitterController.LoggedInUser;
		if (toFollowUser.getFollowersID() == null) {
			String addToDB = followerUser.getUserName() + ",";
			toFollowUser.setFollowersID(addToDB);
		} else {
			String addToDB = toFollowUser.getFollowersID();
			int flag = 0;
			String[] FollowersList = addToDB.split(",", -1);
			for (String follower : FollowersList) {
				if (followerUser.getUserName().equals(follower)) {
					flag = 1;
				}
			}
			if (flag == 0) {
				addToDB += followerUser.getUserName() + ",";
				toFollowUser.setFollowersID(addToDB);
			}
		}
		userRepository.save(toFollowUser);
		if (followerUser.getFollowingIDs() == null) {
			String addToDB = followUserName + ",";
			followerUser.setFollowingIDs(addToDB);
		} else {
			String addToDB = followerUser.getFollowingIDs();
			int flag = 0;
			String[] FollowingList = addToDB.split(",", -1);
			for (String follower : FollowingList) {
				if (followUserName.equals(follower)) {
					flag = 1;
				}
			}
			if (flag == 0) {
				addToDB += followUserName + ",";
				followerUser.setFollowingIDs(addToDB);
			}
		}
		userRepository.save(followerUser);

	}

}
