package server;

import java.util.ArrayList;
import java.util.List;

public class CommandLibrary {
	
	private static final String COMMAND_NOT_FOUND = "Command not found!";
	
	  private ArrayList<CommandClass> commands = new ArrayList<CommandClass>();
	  public void addCommand(CommandClass command)	{
		  commands.add(command);
	  }
	  public void removeCommand(CommandClass command)	{
		  commands.remove(command);
	  }
	  
	  public void parseString(String commandString,String[] arg){
		  boolean notFound = true;
		for(CommandClass c : commands){
			if(c.validCommand(commandString)){
				c.handleCommand(arg);
				notFound = false;
			}
		}
		if(notFound)
			System.out.println(COMMAND_NOT_FOUND);
	  
	  }
	  
}
