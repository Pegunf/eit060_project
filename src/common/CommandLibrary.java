package common;

import java.util.ArrayList;
import java.util.List;

public class CommandLibrary {
	
	
	  private ArrayList<CommandClass> commands = new ArrayList<CommandClass>();
	  public void addCommand(CommandClass command)	{
		  commands.add(command);
	  }
	  public void removeCommand(CommandClass command)	{
		  commands.remove(command);
	  }
	  
	  private String[] getArguments(String text){
		String message = null;
		if (text.contains("'")) {
			int index = text.indexOf('\'');
			message = text.substring(index + 1, text.length() - 1);
			text = text.substring(0, index);
		}
		
		String[] temp = text.split(" ");
		
		int len = temp.length -1;
		
		if (message != null) {
			len++;
		}
		
		String[] returnArg = new String[len];
		int a = 0;
		for(int i = 1;i < temp.length;i++){
			returnArg[a] = temp[i];
			a++;
		}
		if (message != null) {
			returnArg[len-1] = message;
		}
		
		return returnArg;
	  }
	  private String getCommandString(String text){
		  
		  String[] temp = text.split(" ");
		  return temp[0];
	  }
	  
	  public void parseCommand(User user,String cmd){
		for(CommandClass c : commands){
			if(c.validCommand(getCommandString(cmd))){
				c.handleCommand(user, getArguments(cmd));
			}
		}
	  }
	  
}
