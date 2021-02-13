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
	
	public int checkUserCredentials(String username, String password){
		int index = -1;
		boolean correctCredentials = false;
		for(int i = 0; i < accounts.size() && !correctCredentials; i++) {
			if(accounts.get(i).getUserName().equals(username) && accounts.get(i).getPassword().equals(password)){
				correctCredentials = true;
				index = i;
			}//End if
		}//End for
		return index;
	}//End checkUserCredentials.*/
	
	public String[] getUserData(int userIndex){
		String[] userData = new String[6];
		userData[0] = accounts.get(userIndex).getUserName();
		userData[1] = accounts.get(userIndex).getProfilePhoto();
		userData[2] = accounts.get(userIndex).getGender();
		userData[3] = accounts.get(userIndex).getCareers();
		userData[4] = accounts.get(userIndex).getBirthday();
		userData[5] = accounts.get(userIndex).getFavoriteBrowser();
		return userData;
	}//End getUserData
	
	public boolean checkUsername(String username){
		boolean check = false;
		for(int i = 0; i < accounts.size() && !check; i++) 
			if(accounts.get(i).getUserName().equals(username))
				check = true;
		return check;
	}//End checkUsername
	
	public ArrayList<User> getUsersAccounts(){
		return accounts;
	}//End getUsersAccounts
}
