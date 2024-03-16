package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import Models.Data;
import Models.Group;
import Models.Room;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RGController  {
	@FXML public Parent root;
	@FXML public Stage stage;
	@FXML public Scene scene;
	
	@FXML private TextField sizegrouptf=new TextField();
	@FXML private TextField namegrouptf=new TextField();
	@FXML private TextField roomtf=new TextField();
	@FXML private TextField capacityroomtf=new TextField();
	
	@FXML private CheckBox machinechb=new CheckBox();
	
	@FXML private JFXButton addgroupbut= new JFXButton();
	@FXML private JFXButton remgroupbut= new JFXButton();
	@FXML private JFXButton addroombut= new JFXButton();
	@FXML private JFXButton remroombut= new JFXButton();
	
	@FXML private TableView<Group> grouptab=new TableView<>();
	@FXML private TableColumn<Group,Integer> idgroupcol=new TableColumn<>();
	@FXML private TableColumn<Group,String> namegroupcol=new TableColumn<>();
	@FXML private TableColumn<Group,Number> sizegroupcol=new TableColumn<>();
	
	@FXML private TableView<Room> roomtab=new TableView<>();
	@FXML private TableColumn<Room,Integer> idroomcol=new TableColumn<>();
	@FXML private TableColumn<Room,String> roomcol=new TableColumn<>();
	@FXML private TableColumn<Room,Number> capacityroomcol=new TableColumn<>();
	@FXML private TableColumn<Room,Boolean> machinroomcol=new TableColumn<>();

	@FXML public void initialize() {
		idgroupcol.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
		namegroupcol.setCellValueFactory(cellData ->cellData.getValue().getNamegroup());
		sizegroupcol.setCellValueFactory(cellData->cellData.getValue().getoSize());
		grouptab.setItems(Data.groupo);
		idroomcol.setCellValueFactory(cellData->cellData.getValue().getRoid().asObject());
		roomcol.setCellValueFactory(cellData->cellData.getValue().getRonb());
		capacityroomcol.setCellValueFactory(cellData->cellData.getValue().getoRoCapacity());
		machinroomcol.setCellValueFactory(cellData->cellData.getValue().getoRotypeM());
		roomtab.setItems(Data.roomso);
		
	}
	@FXML public void addgroupbut(ActionEvent e) {
		try {
			ObservableValue<String> b=new SimpleStringProperty(this.namegrouptf.getText());
			ObservableValue<Number> a=new SimpleIntegerProperty(Integer.valueOf(this.sizegrouptf.getText()));
			grouptab.getItems().add(new Group(a,b));
		} catch (NumberFormatException e1) {
			
		}
	}
	@FXML public void remgroupbut(ActionEvent e) {
		try {
			grouptab.getItems().remove(grouptab.getSelectionModel().getSelectedIndex());
		} catch (Exception e1) {
						
		}
	}
	@FXML public void addroombut(ActionEvent e) {
		try {
			ObservableValue<String> a =new SimpleStringProperty(roomtf.getText());
			ObservableValue<Boolean> b=new SimpleBooleanProperty(machinechb.isSelected());
			ObservableValue<Number> c=new SimpleIntegerProperty(Integer.valueOf(capacityroomtf.getText()));
            Room room=new Room(a,c,b);
			roomtab.getItems().add(room);
		} catch (NumberFormatException e1) {
			
		}
	}
	@FXML public void machinechb(ActionEvent e) {
	
	}
	@FXML public void remroombut(ActionEvent e) {
		try {
			roomtab.getItems().remove(roomtab.getSelectionModel().getSelectedIndex());
		} catch (Exception e1) {
		}
	}
	@FXML public void next(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/Instructors.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void preview(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/Start.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}