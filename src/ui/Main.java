package ui;
import model.Classroom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private ClassroomGUI cg;
	private Classroom classroom;
	
	public Main() {
		classroom = new Classroom();
		cg = new ClassroomGUI(classroom);
	}//End Constructor
	
	public static void main(String[] args){
		launch(args);
	}//End main
	
	@Override
	public void start(Stage window) throws Exception {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("MainPane.fxml"));
		fxml.setController(cg);
		Parent root = fxml.load();
		Scene scene = new Scene(root,null);
		window.setTitle("ClassromGUI");
		window.setScene(scene);
		cg.loadLoginWindow();
		window.show();
	}//End start

}//End Main.
