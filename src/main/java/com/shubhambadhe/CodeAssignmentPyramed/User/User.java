/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shubham
 *
 */

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	protected int userID;
	
	@Column(name = "username")
	protected String userName;
	
	@Column(name = "following")
	protected String followingIDs;
	
	@Column(name = "followers")
	protected String followersID;


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
