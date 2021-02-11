package ui;
import model.Classroom;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

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
	}//End loadCreateAccountWindow.
	
	@FXML
	public void loadLoginWindow() throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
		fxml.setController(this);
		Parent loginScene = fxml.load();
		MainPanel.getChildren().setAll(loginScene);
	}//End loadCreateAccountWindow.
	
	@FXML
	public void registerUser() {
		if( !txtUsername.getText().equals("") && !txtPassword.getText().equals("") && !pathPhoto.getText().equals("")) {
			classroom.addUserToClassroom(txtUsername.getText(),txtPassword.getText(),getGender(),getCareers(),String.valueOf(date.getValue()),cbFavoriteBrowser.getValue());
		}
	}//End registerUser

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
	
	private String[] getCareers() {
		String[] careers = new String[3];
		
		return careers;
	}//End getCareers
}//End ClassroomGUI
