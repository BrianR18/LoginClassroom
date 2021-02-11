package model;
import java.util.ArrayList;

public class Classroom {
	private ArrayList<User> accounts;
	
	public Classroom(){
		accounts = new ArrayList<User>();
	}//End Constructor.
	
	public void addUserToClassroom(String userName, String password, String gender, String[] careers, String birthday,String browser){
		accounts.add(new User(userName,password,gender,careers,birthday,browser));
	}//End addUserToClassroom.
	
	public ArrayList<User> getUsersAccounts(){
		return accounts;
	}//End getUsersAccounts
}
