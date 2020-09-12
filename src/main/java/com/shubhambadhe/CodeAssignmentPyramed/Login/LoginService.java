/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhambadhe.CodeAssignmentPyramed.Repository.LoginRepository;

/**
 * @author Shubham
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public void addUser(Login login) {
		loginRepository.save(login);
	}

	public int checkLogin(Login loginInfo) {
		int check = -1; // check = -1 is username not found, 0 is login failed, 1 is login success
		Optional<Login> loginfromDB = loginRepository.findById(loginInfo.getUsername());
		if (loginfromDB.isPresent()) {
			if (loginfromDB.get().getPassword().equals(loginInfo.getPassword())) {
				check = 1;
			} else {
				check = 0;
			}
		}
		return check;

	}

}
