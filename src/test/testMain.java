package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import common.HashCrypt;
import common.LoginManager;
import common.PasswordInvalidException;
import common.Record;
import common.User;
import common.UserNotFoundException;

import server.CommandGetRecordContent;
import server.CommandLibrary;

public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		LoginManager loginMan = new LoginManager("serverFiles/userdata.txt");
	
				List<Record> records = new ArrayList<Record>();
				records.add(new Record(0,0,0,0,"LOLCONNTENTNNTNETNNEAKTAENFLKEA"));
				
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
				
			
				CommandLibrary lib = new CommandLibrary();
				CommandGetRecordContent cGetRecord = new CommandGetRecordContent(records);
				lib.addCommand(cGetRecord);
				
				String cmd = "getrecord 1";
				
				System.out.println(CommandLibrary.getArguments(cmd)[0]);
				
				lib.parseString(CommandLibrary.getCommandString(cmd), CommandLibrary.getArguments(cmd));
				
		
		
	}

}
