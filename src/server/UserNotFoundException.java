package server;

public class UserNotFoundException extends Exception{

	 public UserNotFoundException() {
	  }

	  public UserNotFoundException(String msg) {
	    super(msg);
	  }
}
