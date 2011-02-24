package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import common.HashCrypt;
import common.LoginManager;
import common.PasswordInvalidException;
import common.User;
import common.UserNotFoundException;

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
	
				User user;
				try {
					user = loginMan.login("userpatient", "pass1");
					System.out.println(user.getId());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					System.out.println("USER NOT FOUND!");
				} catch (PasswordInvalidException e) {
					System.out.println("PASSWORD INCORRECT!");
				}
				
			
	
		
		
	}

}
