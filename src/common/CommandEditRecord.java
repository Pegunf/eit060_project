package common;

import java.util.List;


public class CommandEditRecord extends CommandClass{

	private List<Record> records;
	public CommandEditRecord(String commandString,List<Record> records) {
		super(commandString);
		this.records = records;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		
		
		/*IMPLEMNENTERA*/
		
	}

}
