package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	public ReadConfig() {
		File src = new File("./config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	
	public String get_url() {
		String url = pro.getProperty("url");
		return url;
	}
	
	public String get_username() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String get_password() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String get_chromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String get_firefoxpath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
