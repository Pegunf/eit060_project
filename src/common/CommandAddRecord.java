package common;

import java.util.List;


public class CommandAddRecord extends CommandClass{

	private List<Record> records;
	public CommandAddRecord(String commandString,List<Record> records) {
		super(commandString);
		this.records = records;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		
		int recordId = Integer.parseInt(arg[0]);
		int nurseId = Integer.parseInt(arg[1]);
		int patientId = Integer.parseInt(arg[2]);
		
		String content = arg[3];
		
		switch(user.getLevel()){
			case User.LEVEL_DOCTOR:
				
				Record newRecord = new Record(recordId, nurseId, user.getId(), patientId, content);
				records.add(newRecord);
				
			break;
		
		}
		
		
	}

	


}