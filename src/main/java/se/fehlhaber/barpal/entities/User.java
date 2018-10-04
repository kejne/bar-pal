package se.fehlhaber.barpal.entities;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import se.fehlhaber.barpal.entities.enums.Role;

/**
 * Table to hold user-information as well as credits-balance
 * 
 * @author Kaj Fehlhaber
 *
 */
@Entity
public class User {

	protected User() {
	}
	
	public User(String userName, String passHash, String email) {
		this.userName = userName;
		this.passHash = passHash;
		this.email = email;
		this.roles = Arrays.asList(Role.USER);
	}
	
	@Id
	@GeneratedValue
	private long userKey;
	
	@Column
	private String userName;
	
	@Column
	private String passHash;
	
	@Column
	private long credits = 0;
	
	@Column
	private String email;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private List<Role> roles;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public long getUserKey() {
		return userKey;
	}
	
	public void addCredits(long creditsToAdd) {
		this.credits += creditsToAdd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (credits ^ (credits >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((passHash == null) ? 0 : passHash.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + (int) (userKey ^ (userKey >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Generated(value = { "eclipse" })
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (credits != other.credits)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (passHash == null) {
			if (other.passHash != null)
				return false;
		} else if (!passHash.equals(other.passHash))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (userKey != other.userKey)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}
	
}
