package config;

import java.io.Serializable;

import beans.Competitor;
import beans.User;
import util.FileUtil;

public class Config implements Serializable {

	private  User user;
	
	private  Competitor[] competitor;
	
	
	public Config(){
		
	}
	
	public Config(User user){
		
	}
	
	
	public  User getUser() {
		return user;
	}

	public  void setUser(User user) {
		this.user = user;
		Initialization.refreshConfig();
	}

	public  Competitor[] getCompetitor() {
		return competitor;
	}

	public  void setCompetitor(Competitor[] competitor) {
		this.competitor = competitor;
		Initialization.refreshConfig();
	}

	

	
	
	
}
