package ui;
import model.Classroom;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ClassroomGUI {
	@FXML private Pane MainPanel;
	@FXML private TextField txtUsername;
	@FXML private TextField txtPassword;
	@FXML private TextField pathPhoto;
	@FXML private DatePicker date;
	@FXML private RadioButton male;
	@FXML private RadioButton female;
	@FXML private RadioButton other;
	@FXML private CheckBox software;
	@FXML private CheckBox telematic;
	@FXML private CheckBox industrial;
	@FXML private ToggleGroup gender;
	@FXML private ComboBox<String> cbFavoriteBrowser;
	@FXML private TableView<User> table;
	@FXML private TableColumn<User,String> username;
	@FXML private TableColumn<User,String> tgender;
	@FXML private TableColumn<User,String> career;
	@FXML private TableColumn<User,String> birthday;
	@FXML private TableColumn<User,String> browser;
	@FXML private Label listName;
	@FXML private ImageView profilePhoto;
	private Image img;
	private String[] currentUserData;
	private ObservableList<String> favoriteBrowser;
	
	private Classroom classroom;
	
	public ClassroomGUI(Classroom cr){
		classroom = cr;
	}//End constructor
	
	@FXML
	public void loadCreateAccountWindow() throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateAccountWindow.fxml"));
		fxml.setController(this);
		Parent createAccountScene = fxml.load();
		MainPanel.getChildren().setAll(createAccountScene);
		initializeComboBox();
		Stage st = (Stage) createAccountScene.getScene().getWindow();
		st.setHeight(515);
		st.setWidth(506);
	}//End loadCreateAccountWindow.
	
	@FXML
	public void loadLoginWindow() throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
		fxml.setController(this);
		Parent loginScene = fxml.load();
		MainPanel.getChildren().setAll(loginScene);
		Stage st = (Stage) loginScene.getScene().getWindow();
		st.setHeight(380);
		st.setWidth(600);
	}//End loadCreateAccountWindow.
	
	@FXML
	public void loadContactListWindow() throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("AccountList.fxml"));
		fxml.setController(this);
		Parent accountListScene = fxml.load();
		MainPanel.getChildren().setAll(accountListScene);
		Stage st = (Stage) accountListScene.getScene().getWindow();
		st.setHeight(481);
		st.setWidth(671);
		initializeAccountsList();
		loadCurrentUserInformation();
	}//End loadContactListWindow.
	
	@FXML
	public void registerUser() {
		Alert statusInfo = new Alert(null);
		if( !txtUsername.getText().equals("") && !txtPassword.getText().equals("") 
			&& !pathPhoto.getText().equals("") && date.getValue() != null && cbFavoriteBrowser.getValue() != null) {
			if(!classroom.checkUsername(txtUsername.getText())) {
				classroom.addUserToClassroom(txtUsername.getText(),txtPassword.getText(),getGender(),
						getCareers(),String.valueOf(date.getValue()),cbFavoriteBrowser.getValue(),pathPhoto.getText()
						);
				txtUsername.setText("");
				txtPassword.setText("");
				pathPhoto.setText("");
				date.setValue(null);
				cbFavoriteBrowser.setValue(null);
				statusInfo.setAlertType(AlertType.INFORMATION);
				statusInfo.setHeaderText(null);
				statusInfo.setContentText("The new account has been created.");
			}//End intern if
			else {
				statusInfo.setAlertType(AlertType.ERROR);
				statusInfo.setHeaderText(null);
				statusInfo.setContentText("The username \""+txtUsername.getText()+"\" is already in use." );	
			}
		}//End if
		else{
			statusInfo.setAlertType(AlertType.ERROR);
			statusInfo.setHeaderText(null);
			statusInfo.setContentText("You must fill each field in the form.");
		}
		statusInfo.showAndWait();
	}//End registerUser
	
	@FXML
	public void loginUser(){
		Alert loginInfo = new Alert(AlertType.ERROR);
		loginInfo.setHeaderText(null);
		loginInfo.setContentText("The username and password given are incorrect");
		int currentUserIndex = classroom.checkUserCredentials(txtUsername.getText(), txtPassword.getText());
		
		if(currentUserIndex != -1){
			currentUserData = classroom.getUserData(currentUserIndex);
			try {
				loadContactListWindow();
			}catch(IOException e){}
		}//End if
		else
			loginInfo.showAndWait();
	}//End loginUser
	
	@FXML
	public void chooseProfilePhoto() {
		FileChooser imgPath = new FileChooser();
		imgPath.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
		if(imgPath != null) {
			File img = imgPath.showOpenDialog(null);
			pathPhoto.setText(String.valueOf(img));
		}
	}//End chooseProfilePhoto
	
	private void initializeComboBox() {
		favoriteBrowser = FXCollections.observableArrayList();
		favoriteBrowser.add("Chrome");
		favoriteBrowser.add("Firefox");
		favoriteBrowser.add("Edge");
		favoriteBrowser.add("Opera");
		favoriteBrowser.add("Opera GX");
		favoriteBrowser.add("Brave");
		favoriteBrowser.add("Vivaldi");
		favoriteBrowser.add("Thor");
		favoriteBrowser.add("Safari");
		cbFavoriteBrowser.setItems(favoriteBrowser);
	}//End initializeComboBox*/
	
	private String getGender() {
		String rbtnOn = new String();
		if(male.isSelected())
			rbtnOn = "Male";
		else if(female.isSelected())
			rbtnOn = "Female";
		else	
			rbtnOn = "Other";
		return rbtnOn;
	}//End getRadioBtnOn
	
	private ArrayList<String> getCareers() {
		ArrayList<String> careers = new ArrayList<String>();
		if(software.isSelected()){
			careers.add("SOFTWARE_ENGINEERING");
			software.setSelected(false);
		}
		if(telematic.isSelected()){
			careers.add("TELEMATIC_ENGINEERING");
			telematic.setSelected(false);
		}
		if(industrial.isSelected()){
			careers.add("INDUSTRIAL_ENGINEERING");
			industrial.setSelected(false);
		}
		return careers;
	}//End getCareers
	
	private void initializeAccountsList(){
		ObservableList<User> contactList = FXCollections.observableArrayList(classroom.getUsersAccounts());
		 table.setItems(contactList);
		 username.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		 tgender.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
		 career.setCellValueFactory(new PropertyValueFactory<User,String>("careers"));
		 birthday.setCellValueFactory(new PropertyValueFactory<User,String>("birthday"));
		 browser.setCellValueFactory(new PropertyValueFactory<User,String>("favoriteBrowser"));
	}//End initializeAccountsList
	private void loadCurrentUserInformation() {
		listName.setText(currentUserData[0]);
		File file = new File(currentUserData[1]);
		img  = new Image(file.toURI().toString());
		profilePhoto.setImage(img);
	}//End loadCurrentUserInformation
	@FXML
	public void logout(){
		currentUserData = null;
		try {
			loadContactListWindow();
		}catch(IOException e){}
	}//End logout
}//End ClassroomGUI
