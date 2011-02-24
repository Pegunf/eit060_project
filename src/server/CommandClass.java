package server;

public interface CommandClass {
	
	
	public boolean validCommand(String command);
	public void handleCommand(String[] arg);
}
