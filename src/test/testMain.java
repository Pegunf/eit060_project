package test;

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
	}

}
