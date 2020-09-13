/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Chit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhambadhe.CodeAssignmentPyramed.Repository.ChitRepository;
import com.shubhambadhe.CodeAssignmentPyramed.User.User;
import com.shubhambadhe.CodeAssignmentPyramed.User.UserMethods;

/**
 * @author Shubham
 *
 */
@Service
public class ChitService {

	@Autowired
	ChitRepository chitRepository;

	@Autowired
	UserMethods userService;

	public void postChit(Chit chit) {
		chitRepository.save(chit);
	}

	public HashMap<String, List<Chit>> getChitsByFollowers(String userName) {
		HashMap<String, List<Chit>> chitMap = new HashMap<>();
		User user = userService.getUser(userName);
		String following = user.getFollowingIDs();
		if (following != null) {
			String[] followingList = following.split(",", -1);
			for (String followingUser : followingList) {
				List<Chit> chits = getChitsByUser(followingUser);
				chitMap.put(followingUser, chits);
			}
		}
		return chitMap;
	}

	public List<Chit> getChitsByUser(String followingUser) {
		List<Chit> ListChits = (List<Chit>) chitRepository.findAll();
		List<Chit> chits = new ArrayList<>();
		for (Chit chit : ListChits) {
			if (chit.getUsername().equals(followingUser)) {
				chits.add(chit);
			}
		}
		return chits;
	}

}
