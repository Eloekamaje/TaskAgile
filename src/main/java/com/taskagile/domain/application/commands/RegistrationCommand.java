package com.taskagile.domain.application.commands;

import org.springframework.util.Assert;

public class RegistrationCommand {
	
	private String username;
	private String emailAddress;
	private String password;


	public RegistrationCommand(String username, String emailAddress, String password) {
		Assert.hasText(username, "Parameter `username` must not be empty");
	    Assert.hasText(emailAddress, "Parameter `emailAddress` must not be empty");
	    Assert.hasText(password, "Parameter `password` must not be empty");
	    this.username = username;
	    this.emailAddress = emailAddress;
	    this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public String getPassword() {
		return password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationCommand other = (RegistrationCommand) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RegistrationCommand{" +
	      "username='" + username + '\'' +
	      ", emailAddress='" + emailAddress + '\'' +
	      ", password='" + password + '\'' +
	      '}';
	}
	
}
