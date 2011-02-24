package common;

public class User {

	private int level;
	private int id;
	private UserInformation info;
	
	public User(int id, int level, UserInformation info){
		this.id = id;
		this.level = level;
		this.info = info;
	}

	public int getId(){
		return id;
	}
	
}
