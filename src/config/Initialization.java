package config;

import beans.User;
import util.FileUtil;

public class Initialization {
	
	public static Config config;
	
	public static void initializeConfig(User user){
		config=new Config(user);
		//config.setUser(user);
		try {
			Object configObj=FileUtil.readObjectFromFile("config.ser");
				config=(Config)configObj;
		} catch (Exception e) {
			//ignore
			e.printStackTrace();
		}
		
	}
	
	public static void refreshConfig(){
		FileUtil.writeObjectToFile(config, "config.ser");
	}
}
