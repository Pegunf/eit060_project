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
		
		int recordId = Integer.parseInt(arg[0]);
		String newContent = arg[1];
		
		for(Record r : records){
			if(r.getId() == recordId){
				switch(user.getLevel()){
				case User.LEVEL_DOCTOR:
					if(user.getId() == r.getDoctorId()){
						r.setContent(newContent);
					}
				break;
				case User.LEVEL_NURSE:
					if(user.getId() == r.getNurseId()){
						r.setContent(newContent);
					}
				break;			
				}
			}
		}
		
		
	}

}
