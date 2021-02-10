package model;

public class User {
	private String userName;
	private String password;
	private String profilePhoto;
	private String gender;
	private String[] careers;
	private String birthday;
	private String favoriteBrowser;
	
	public User(){
		userName = new String();
		password = new String();
		profilePhoto = new String();
		gender = new String();
		careers = new String[3];
		birthday = new String();
		favoriteBrowser = new String();
	}//End constructor.
	
	public User(String userName, String password, String gender, String[] careers, String birthday,String browser){
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.careers = careers;
		this.birthday = birthday;
		favoriteBrowser = browser;
	}//End User
	
	public void setProfilePhoto(String p){
		profilePhoto = p;
	}//End setProfilePhoto
	public String getProfilePhoto() {
		return profilePhoto;
	}//End getProfilePhoto
	public String getUserName(){
		return userName;
	}//End getUserName.
	public String getPassword(){
		return password;
	}//End getPassword.
	public String getGender(){
		return gender;
	}//End getGender.
	public String[] getCareers(){
		return careers;
	}//End getCareers
	public String getBirthday(){
		return birthday;
	}//End getBirthday
	public String getFavoriteBrowser(){
		return favoriteBrowser;
	}//End getFavoriteBrowser
}//End User
