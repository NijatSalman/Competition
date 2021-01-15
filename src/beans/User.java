package beans;

import java.io.Serializable;

import config.Initialization;


public class User implements Serializable {

	private String userName;
	private String password;
	private int userPoint;
	
	public User(){
		
	}
	
	public User(String userName,String password){
		this.userName=userName;
		this.password=password;
	
	}
	
	public User(String userName,String password,int userPoint){
		this.userName=userName;
		this.password=password;
		this.userPoint=userPoint;
	}
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
		Initialization.refreshConfig();
	}
	
	
	
	
}
