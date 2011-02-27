package common;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class CommandDeleteRecord extends CommandClass{

	private List<Record> records;
	private PrintStream outStream;
	public CommandDeleteRecord(String commandString,List<Record> records,PrintStream outStream) {
		super(commandString);
		this.records = records;
		this.outStream = outStream;
	}

	@Override
	protected void handleCommand(User user, String[] arg) {
		try{
			int recordId = Integer.parseInt(arg[0]);
			Iterator<Record> itr = records.iterator();
			while(itr.hasNext()){
				Record r = itr.next();
				if(r.getId() == recordId){
					
					switch(user.getLevel()){
						case User.LEVEL_GOV:
							itr.remove();
							outStream.println("Record removed.");
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
