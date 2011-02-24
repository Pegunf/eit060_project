package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import common.HashCrypt;
import common.LoginManager;
import common.User;

import server.CommandLibrary;
import server.CommandTest;

public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*COMMAND LIB TEST*/
		CommandLibrary lib = new CommandLibrary();
		CommandTest test = new CommandTest();
		lib.addCommand(test);
		lib.parseString("lol" , null);
		
		LoginManager loginMan = new LoginManager("serverFiles/userdata.txt");
	
			try {
				User user = loginMan.login("userpatient", "pass1");
				
				System.out.println(user.getId());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
	}

}
