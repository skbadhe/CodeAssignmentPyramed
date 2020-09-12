package com.shubhambadhe.CodeAssignmentPyramed.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterUser {

	@Id
	int userID;
	String userName;
	String password;
	String followingIDs;
	String followersID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFollowingIDs() {
		return followingIDs;
	}

	public void setFollowingIDs(String followingIDs) {
		this.followingIDs = followingIDs;
	}

	public String getFollowersID() {
		return followersID;
	}

	public void setFollowersID(String followersID) {
		this.followersID = followersID;
	}

}
