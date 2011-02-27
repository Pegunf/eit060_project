package common;

import java.io.PrintStream;
import java.util.List;


public class CommandGetRecordContent extends CommandClass {

	
	private PrintStream outStream;
	private List<Record> records;
	public CommandGetRecordContent(String commandString,List<Record> records,PrintStream outStream){
		super(commandString);
		this.records = records;
		this.outStream = outStream;
	}
	
	public void handleCommand(User user,String[] arg) {
	
		try{
		int recordId = Integer.parseInt(arg[0]);
		
		for(Record r : records){
			if(r.getId() == recordId){
				
				switch(user.getLevel()){
				
					case User.LEVEL_PATIENT:
						if(user.getId() == r.getPatientId()){
							outStream.println(r.getContent());
						}
					break;
					case User.LEVEL_NURSE:
						if(user.getId() == r.getNurseId() || (user.getDivision() == r.getDivisionId())){
							outStream.println(r.getContent());
						}
					break;
					case User.LEVEL_DOCTOR:
						if(user.getId() == r.getDoctorId() || (user.getDivision() == r.getDivisionId())){
							outStream.println(r.getContent());
						}
					break;
					case User.LEVEL_GOV:
						outStream.println(r.getContent());
					break;
					default:
						outStream.println("Premission denied!");
					break;
				
				}
				
			}
		
		}
		}catch(Exception e){
			outStream.println("An error occurred!");
		}
	}

}
