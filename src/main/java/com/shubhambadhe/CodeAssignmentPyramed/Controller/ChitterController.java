/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shubham
 *
 */
@RestController
public class ChitterController {
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	String register() {
		return "";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	String login() {
		return "";
	}
	
	@RequestMapping(value="/postChit", method=RequestMethod.POST)
	String postChit() {
		return "";
	}
	
	@RequestMapping(value="/follow", method=RequestMethod.POST)
	String followUser() {
		return "";
	}
	
	@RequestMapping(value="/getChit", method=RequestMethod.GET)
	String GetFollowedChits() {
		return "";
	}
	
	

}
