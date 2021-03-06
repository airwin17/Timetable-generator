package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage Stage) {
		try {
			Parent root= FXMLLoader.load(getClass().getResource("Start.fxml"));
			
			Scene scene = new Scene(root);
			Stage.setScene(scene);
			Stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
