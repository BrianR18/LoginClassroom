package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ClassroomGUI {
	@FXML private Pane MainPanel;
	@FXML private TextField txtUsername;
	@FXML private TextField txtPassword;
	
	@FXML
	public void loadCreateAccountWindow() throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("CreateAccountWindow.fxml"));
		fxml.setController(this);
		Parent createAccountScene = fxml.load();
		MainPanel.getChildren().setAll(createAccountScene);
	}//End loadCreateAccountWindow.
	
}//End ClassroomGUI
