package server;


public abstract class CommandClass {
	
	private String commandString;
	public CommandClass(String commandString){
		this.commandString = commandString;
	}
	
	public boolean validCommand(String command){
		return commandString.equals(command);
	}
	protected abstract void handleCommand(User user, String[] arg);
}
