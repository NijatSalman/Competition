package util;

import java.util.Scanner;

import beans.User;
import config.Config;
import config.Initialization;

public class UserUtil {
	
	 public static User login(String name,String password){
		 
		 if("Nijat".equals(name) && "12345".equals(password)){
			 User user=new User(name,password);
			 return user;
		 }
		 
		 throw new IllegalArgumentException("UserName or Password is incorrect");
	 }
	 
	 public static User requiredInputsAndLogin(){
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Please type your userName");
			String userName=sc.nextLine();
			
			System.out.println("Please type your password");
			String password=sc.nextLine();
			
			User user=UserUtil.login(userName, password);
		//	Config.setUser(user);
		//	Initialization.config.setUser(user);
			
			return user;
			
	 }
	 
	 public static User requiredInputsAndLogin(int tryCount, boolean throwException){
		 
		 for(int i=0;i<tryCount;i++){
			 try {
				
				User user= requiredInputsAndLogin();
				
				return user;
			} catch (Exception ex) {
				
				System.out.println(ex.getMessage());
		
			}		 
		 }
		 if(throwException){
			 throw new IllegalArgumentException("You have banned!");
		 }else{
			 return null;
		 }
	 }
	 

}
