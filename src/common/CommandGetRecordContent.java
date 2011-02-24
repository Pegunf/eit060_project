package common;

import java.util.List;


public class CommandGetRecordContent extends CommandClass {

	
	private List<Record> records;
	public CommandGetRecordContent(String commandString,List<Record> records){
		super(commandString);
		this.records = records;
	}
	
	public void handleCommand(User user,String[] arg) {
		int recordId = Integer.parseInt(arg[0]);
		
		for(Record r : records){
			if(r.getId() == recordId){
				
				switch(user.getLevel()){
				
					case User.LEVEL_PATIENT:
						if(user.getId() == r.getPatientId()){
							System.out.println(r.getContent());
						}
					break;
					case User.LEVEL_NURSE:
						if(user.getId() == r.getNurseId()){
							System.out.println(r.getContent());
						}
					break;
					case User.LEVEL_DOCTOR:
						if(user.getId() == r.getDoctorId()){
							System.out.println(r.getContent());
						}
					break;
					case User.LEVEL_GOV:
						System.out.println(r.getContent());
					break;
				
				}
				
			}
		
		}
	}

}
