package com.revature.model;

public class User {
  private int userId;
  private String firstName;
  private String lastNAme;
  private String email;
  private String password;
  private int isManger;
public User(int userId, String firstName, String lastNAme,
    String email, String password, int isManger) {
	super();
	this.userId = userId;
	this.firstName = firstName;
	this.lastNAme = lastNAme;
	this.email = email;
	this.password = password;
	this.isManger = isManger;
}
public User() {
	
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastNAme() {
	return lastNAme;
}
public void setLastNAme(String lastNAme) {
	this.lastNAme = lastNAme;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getIsManger() {
	return isManger;
}
public void setIsManger(int isManger) {
	this.isManger = isManger;
}
@Override
public String toString() {
  return "User [userId=" + userId + ", firstName=" + firstName + ", lastNAme=" + lastNAme
      + ", email=" + email + ", password=" + password + ", isManger=" + isManger + "]";
}


}
