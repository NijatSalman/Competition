import java.util.Scanner;

import beans.Competitor;
import beans.User;
import config.Config;
import config.Initialization;
import util.CompetitonUtil;
import util.MenuUtil;
import util.UserUtil;

public class Main {

	
	public static void main(String[] args) {
		
		User user=UserUtil.requiredInputsAndLogin(1,true);
		Initialization.initializeConfig(user);
		System.out.println("Hello "+user.getUserName());
	    MenuUtil.showMenuInfinite();
	    
	}

}
