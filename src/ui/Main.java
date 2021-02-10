package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	ClassroomGUI cg;
	
	public Main() {
		cg = new ClassroomGUI();
	}//End Constructor
	
	public static void main(String[] args){
		launch(args);
	}//End main
	
	@Override
	public void start(Stage window) throws Exception {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
		fxml.setController(cg);
		Parent root = fxml.load();
		Scene scene = new Scene(root);
		window.setTitle("ClassromGUI");
		window.setScene(scene);
		window.show();
	}//End start

}//End Main.
