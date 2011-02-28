package server;

import java.io.PrintStream;
import java.util.List;


public class CommandAddRecord extends CommandClass{

	private List<Record> records;
	private PrintStream outStream;
	public CommandAddRecord(String commandString,List<Record> records,PrintStream outStream) {
		super(commandString);
		this.records = records;
		this.outStream = outStream;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		
		try{
		int recordId = Integer.parseInt(arg[0]);
		int nurseId = Integer.parseInt(arg[1]);
		int patientId = Integer.parseInt(arg[2]);
		
		String content = arg[3];
		
		if(user.areLoggedIn()){
			switch(user.getLevel()){
				case User.LEVEL_DOCTOR:
					
					Record newRecord = new Record(recordId, nurseId, user.getId(), patientId,user.getDivision(), content);
					records.add(newRecord);
					outStream.println("Record added!");
				break;
			
				default:
					outStream.println("Premission denied!");
				break;
			}
			}else{
				outStream.println("You are not logged in!");
			}

		
		}catch(Exception e){	
			outStream.println("An error occurred!");
		}
				
	}

	


}
