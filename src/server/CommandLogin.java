package server;

import java.io.IOException;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;

public class CommandLogin extends CommandClass{
	
	private LoginManager loginManager;
	private PrintStream printStream;
	
	public CommandLogin(String commandString,LoginManager loginManager, PrintStream printStream) {
		super(commandString);
		this.loginManager = loginManager;
		this.printStream = printStream;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		
		String username = arg[0];
		String password = arg[1];
		
			try {
				loginManager.login(username, password);
				printStream.println("Login successfully!");
				
			} catch (UserNotFoundException e) {
				printStream.println("Username not found.");
			} catch (PasswordInvalidException e) {
				printStream.println("Password invalid.");
			} catch (Exception e) {
				printStream.println("An error occurred.");
			}
		
		
	}

}
