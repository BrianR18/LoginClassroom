package model;

import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private String profilePhoto;
	private Gender gender;
	private ArrayList<Careers> careers;
	private String birthday;
	private String favoriteBrowser;
	
	public User(){
		userName = new String();
		password = new String();
		profilePhoto = new String();
		gender = null;
		careers = new ArrayList<Careers>();
		birthday = new String();
		favoriteBrowser = new String();
	}//End constructor.
	
	public User(String userName, String password, String gender, String birthday,String browser){
		this.userName = userName;
		this.password = password;
		this.gender = Gender.valueOf( gender.toUpperCase());
		this.birthday = birthday;
		favoriteBrowser = browser;
		careers = new ArrayList<Careers>();
		profilePhoto = new String();
	}//End User
	
	public void setProfilePhoto(String p){
		profilePhoto = p;
	}//End setProfilePhoto
	public void setCareers(ArrayList<String> c) {
		for(int i = 0; i < c.size(); i++)
			careers.add(Careers.valueOf( c.get(i) ));
	}//End setCareerss
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
		return gender.toString();
	}//End getGender.
	public ArrayList<String> getCareers(){
		ArrayList<String> c = new ArrayList<String>();
		for(int i = 0; i < careers.size(); i++)
				c.add(careers.get(i).toString());
		return c;
	}//End getCareers
	public String getBirthday(){
		return birthday;
	}//End getBirthday
	public String getFavoriteBrowser(){
		return favoriteBrowser;
	}//End getFavoriteBrowser
	
}//End User
