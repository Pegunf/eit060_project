package server;

public class PasswordInvalidException extends Exception{
	
	public PasswordInvalidException(){
		
	}
	public PasswordInvalidException(String msg){
		super(msg);
	}

}
