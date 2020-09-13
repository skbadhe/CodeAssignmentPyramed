/**
 * 
 */
package com.shubhambadhe.CodeAssignmentPyramed.Chit;

import java.sql.Time;

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
@Table(name = "CHITS")
public class Chit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chitid")
	protected int chitid;

	@Column(name = "username")
	protected String username;

	@Column(name = "chit")
	protected String chit;

	@Column(name = "timeofchit")
	protected Time time;

	public int getChitid() {
		return chitid;
	}

	public void setChitid(int chitid) {
		this.chitid = chitid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChit() {
		return chit;
	}

	public void setChit(String chit) {
		this.chit = chit;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
