package com.project.rms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Id
	String userId;
	
	String userName;
	String userEmail;
	String userMobileNo;
	String userPassword;
	String userDateOfBirth;
	String userGender;
	String userAddress;
	 
	public User() {
		
	}

	public User(String userName, String userEmail, String userMobileNo, String userPassword, String userDateOfBirth,
			String userGender, String userAddress) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNo = userMobileNo;
		this.userPassword = userPassword;
		this.userDateOfBirth = userDateOfBirth;
		this.userGender = userGender;
		this.userAddress = userAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(String userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobileNo="
				+ userMobileNo + ", userPassword=" + userPassword + ", userDateOfBirth=" + userDateOfBirth + ", userGender=" + userGender
				+ ", userAddress=" + userAddress + "]";
	}

}

