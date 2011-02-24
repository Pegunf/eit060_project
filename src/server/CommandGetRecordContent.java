package server;

import java.util.List;

import common.Record;

public class CommandGetRecordContent implements CommandClass {

	
	private List<Record> records;
	public CommandGetRecordContent(List<Record> records){
		this.records = records;
	}
	
	@Override
	public boolean validCommand(String command) {
		return command.equals("getrecord");
	}

	@Override
	public void handleCommand(String[] arg) {
		int recordId = Integer.parseInt(arg[0]);
		
		for(Record r : records){
			if(r.getId() == recordId){
				
				System.out.println(r.getContent());
				
			}
		
		}
	}

}
