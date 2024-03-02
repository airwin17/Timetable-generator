package application;

import java.io.IOException;

import javax.xml.crypto.Data;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartController {
	@FXML public TextField dpwtf=new TextField();
	@FXML public TextField ppdtf=new TextField();
	@FXML public JFXButton nxtbn=new JFXButton();
	@FXML public Parent root;
	@FXML public Stage stage;
	@FXML public Scene scene;
	public void initialize(){
		nxtbn.disableProperty().set(true);
		dpwtf.textProperty().addListener((obs,newv,oldv)->{
			try {
				if(Integer.parseInt(dpwtf.getText())<=7&&Integer.parseInt(ppdtf.getText())<=8){
					nxtbn.disableProperty().set(false);
				}else
				nxtbn.disableProperty().set(true);
			} catch (NumberFormatException e) {
				nxtbn.disableProperty().set(true);
			}
		});
		ppdtf.textProperty().addListener((obs,newv,oldv)->{
			try {
				if(Integer.parseInt(dpwtf.getText())<=7&&Integer.parseInt(ppdtf.getText())<=8){
					nxtbn.disableProperty().set(false);
				}else
				nxtbn.disableProperty().set(true);
			} catch (NumberFormatException e) {
				nxtbn.disableProperty().set(true);
			}
			
		});
	}
	@FXML public void nxtn(ActionEvent e) throws IOException {
		
		try {
			if (Integer.parseInt(dpwtf.getText())<=7&&Integer.parseInt(ppdtf.getText())<=8) {
				Data.daysPerWeek=Integer.parseInt(dpwtf.getText());
				Data.periodsPerDay=Integer.parseInt(ppdtf.getText());
				root= FXMLLoader.load(getClass().getResource("Rooms and Groups.fxml"));
				stage= (Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		} catch (NumberFormatException e1) {
			
			
		} catch (IOException e1) {
			
		}
	}

}
