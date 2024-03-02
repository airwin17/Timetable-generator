package malikait;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage Stage) {
		try {
			URL url=getClass().getResource("/Start.fxml");
			System.out.println();
			System.out.println(url);
			Parent root= FXMLLoader.load(url);
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