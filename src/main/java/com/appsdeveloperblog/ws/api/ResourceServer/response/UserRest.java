package com.appsdeveloperblog.ws.api.ResourceServer.response;

public class UserRest {

	private String userFirstName;
	private String userLastName;
	private String userId;
	
	public UserRest(String userFirstName, String userLastName, String userId) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userId = userId;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
