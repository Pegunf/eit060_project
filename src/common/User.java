package common;

public class User {

	public static final int LEVEL_PATIENT = 0;
	public static final int LEVEL_NURSE = 1;
	public static final int LEVEL_DOCTOR = 2;
	public static final int LEVEL_GOV = 3;
	
	private int level;
	private int division;
	private int id;
	private UserInformation info;
	
	private boolean loggedIn;
	
	public User(int id, int level,int division, UserInformation info){
		this.id = id;
		this.level = level;
		this.info = info;
		this.division = division;
		this.loggedIn = true;
	}
	public User(){
		this.loggedIn = false;
	}

	public boolean areLoggedIn(){
		return loggedIn;
	}
	public int getId(){
		return id;
	}
	public int getDivision(){
		return division;
	}
	
	public int getLevel(){
		return level;	
	}
}
