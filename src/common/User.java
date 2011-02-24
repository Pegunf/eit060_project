package common;

public class User {

	public static final int LEVEL_PATIENT = 0;
	public static final int LEVEL_NURSE = 1;
	public static final int LEVEL_DOCTOR = 2;
	public static final int LEVEL_GOV = 3;
	
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
	
	public int getLevel(){
		return level;	
	}
}
