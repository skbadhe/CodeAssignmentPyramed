/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shubham
 *
 */

@Entity
@Table(name = "USERPASS")
public class Login {

	@Id
	@Column(name = "username")
	protected String username;

	@Column(name = "password")
	protected String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
