package common;

import java.io.PrintStream;
import java.util.List;


public class CommandEditRecord extends CommandClass{

	private List<Record> records;
	private PrintStream outStream;
	public CommandEditRecord(String commandString,List<Record> records,PrintStream outStream) {
		super(commandString);
		this.records = records;
		this.outStream = outStream;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		
		
		try{
			if(user.areLoggedIn()){
			int recordId = Integer.parseInt(arg[0]);
			String newContent = arg[1];
			for(Record r : records){
				if(r.getId() == recordId){
					
					switch(user.getLevel()){
						case User.LEVEL_NURSE:
							if(user.getId() == r.getNurseId()){
								r.setContent(newContent);
								outStream.println("Record changed.");
							}
						break;
						case User.LEVEL_DOCTOR:
							if(user.getId() == r.getDoctorId()){
								r.setContent(newContent);
								outStream.println("Record changed.");
							}
						break;
						default:
							outStream.println("Premission denied!");
						break;
					}
					
				}
			
			}
			}else{
				outStream.println("Not logged in!");
			}
			}catch(Exception e){
				outStream.println("An error occurred!");
			}
		
	}

}
