package server;

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
		ArrayList<String> messages = new ArrayList<String>();
		
		if (text.contains("'")) {
			String split[] = text.split("'");
			text = split[0];
			
			for (int i = 1; i < split.length; i += 2) {
				if(split[i] !=null) messages.add(split[i]);
			}
		}
		
//		if (text.contains("'")) {
//			int index = text.indexOf('\'');
//			message = text.substring(index + 1, text.length() - 1);
//			text = text.substring(0, index);
//		}
		
		String[] temp = text.split(";");
		
		int len = temp.length - 1;
		
		if (!messages.isEmpty()) {
			len += messages.size();
		}
		
		String[] returnArg = new String[len];
		int a = 0;
		
		for(int i = 1;i < temp.length - 1;i++){
			returnArg[a] = temp[i];
			a++;
		}
		if (!messages.isEmpty()) {
			int i = temp.length - 1;
			for (String s : messages) {
				returnArg[i] = s;
				i++;
			}
		}
		
		return returnArg;
	  }
	  private String getCommandString(String text){
		  
		  String[] temp = text.split(";");
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
