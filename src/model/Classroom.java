package model;
import java.util.ArrayList;

public class Classroom {
	private ArrayList<User> accounts;
	
	public Classroom(){
		accounts = new ArrayList<User>();
	}//End Constructor.
	
	public void addUserToClassroom(String userName, String password, String gender, ArrayList<String> careers, String birthday,String browser,String photo){
		User user = new User(userName,password,gender,birthday,browser);
		user.setCareers(careers);
		user.setProfilePhoto(photo);
		accounts.add(user);
	}//End addUserToClassroom.
	
	public ArrayList<User> getUsersAccounts(){
		return accounts;
	}//End getUsersAccounts
}
