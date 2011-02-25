package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import common.CommandAddRecord;
import common.CommandEditRecord;
import common.CommandGetRecordContent;
import common.CommandLibrary;
import common.HashCrypt;
import common.LoginManager;
import common.PasswordInvalidException;
import common.Record;
import common.User;
import common.UserNotFoundException;


public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	/*	
		LoginManager loginMan = new LoginManager("serverFiles/userdata.txt");
	
				List<Record> records = new ArrayList<Record>();
				records.add(new Record(0,0,0,0,0,"LOLCONNTENTNNTNETNNEAKTAENFLKEA"));
				
				User userDoc = null;
				User userPat = null;
				try {
					userDoc = loginMan.login("userdoc", "pass2");
					userPat = loginMan.login("userpatient", "pass1");
					
					
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
				CommandGetRecordContent cGetRecord = new CommandGetRecordContent("getrecord",records);
				//CommandAddRecord cAddRecord = new CommandAddRecord("addrecord", records);
				CommandEditRecord cEditRecord = new CommandEditRecord("editrecord", records);
				
				lib.addCommand(cGetRecord);
				//lib.addCommand(cAddRecord);
				lib.addCommand(cEditRecord);
				
				String cmdAddRec = "addrecord 1 0 0 'Detta är lite content!'";
				String cmdGet = "getrecord 1";
				String cmdEditRec = "editrecord 1 'New Content'";
				
				lib.parseCommand(userDoc, cmdAddRec);
				lib.parseCommand(userPat, cmdGet);
				lib.parseCommand(userDoc, cmdEditRec);
				lib.parseCommand(userPat, cmdGet);
		
		*/
	}

}
