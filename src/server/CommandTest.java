package server;

public class CommandTest implements CommandClass{

	@Override
	public boolean validCommand(String command) {
		// TODO Auto-generated method stub
		return command.equals("lol");
	}

	@Override
	public void handleCommand(String[] arg) {
		// TODO Auto-generated method stub
		System.out.println("LOL MEDDELANDE!");
	}

}
