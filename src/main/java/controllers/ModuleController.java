package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;

import Models.Module;
import Models.Data;
import Models.Instructor;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ModuleController {
	@FXML public Parent root;
	@FXML public Stage stage;
	@FXML public Scene scene;
	
	@FXML private JFXComboBox<Instructor> instcb=new JFXComboBox<>();
	
	@FXML private JFXCheckBox machinecb =new JFXCheckBox();
	
	@FXML private TextField moduletf=new TextField();
	
	@FXML private JFXButton addmodbut=new JFXButton();
	@FXML private JFXButton remmodbut=new JFXButton();
	@FXML private JFXButton addinstbut=new JFXButton();
	@FXML private JFXButton reminstbut=new JFXButton();
	
	@FXML private TableView<Module> modtab=new TableView<>();
	@FXML private TableColumn<Module,Integer> idmodcol=new TableColumn<>();
	@FXML private TableColumn<Module,String> modcol=new TableColumn<>();
	@FXML private TableColumn<Module,Boolean> machinemodcol=new TableColumn<>();
	
	@FXML private TableView<Instructor> instructortab=new TableView<>();
	@FXML private TableColumn<Instructor,String> nameinstcol=new TableColumn<>();
	@FXML private TableColumn<Instructor,Integer> idinstcol=new TableColumn<>();
	
	@FXML public void initialize() {
		idmodcol.setCellValueFactory(cellData->cellData.getValue().getId().asObject());
		modcol.setCellValueFactory(cellData->cellData.getValue().getModuleName());
		machinemodcol.setCellValueFactory(cellData->cellData.getValue().getoRequiremroom());
		modtab.setItems(Data.moduleo);
		
	}
	@FXML public void addbut(ActionEvent e) {
		
		Module m=new Module(new SimpleStringProperty(moduletf.getText()),new SimpleBooleanProperty(machinecb.isSelected()));
		modtab.getItems().add(m);
	}
	@FXML public void remmodbut(ActionEvent e) {
		try {
			modtab.getItems().remove(this.modtab.getSelectionModel().getSelectedIndex());
		} catch (Exception e1) {
			
		}
	}
	@FXML public void hundle() {
		nameinstcol.setCellValueFactory(cellData->cellData.getValue().getInsoName());
		idinstcol.setCellValueFactory(cellData->cellData.getValue().getInsID().asObject());
		instructortab.setItems(modtab.getSelectionModel().getSelectedItem().getInstructorso());
		instcb.setItems(Data.instructorso);
		instcb.setConverter(new StringConverter<Instructor>() {

			@Override
			public Instructor fromString(String s) {
				Instructor k=null;
				for(int i=0;i<Data.instructorso.sorted().size();i++) {
					if (s.equals(Data.instructorso.sorted().get(i).getInsoName().getValue())) {
						k=Data.instructorso.sorted().get(i);
					}
					
				}
				return k;
			}

			
			public String toString(Instructor i) {
				String e =i.getInsoName().getValue();
				return e;
			}
			
		});
	}
	@FXML public void addinstbut(ActionEvent e) {
		if(modtab.getSelectionModel().getSelectedItem()!=null && this.instcb.getSelectionModel().getSelectedItem()!=null) {
			modtab.getSelectionModel().getSelectedItem().getInstructorso().add(this.instcb.getSelectionModel().getSelectedItem());
			modtab.getSelectionModel().getSelectedItem().refrech();
		}
	}
	@FXML public void reminstbut(ActionEvent e) {
		if(instructortab.getSelectionModel().getSelectedItem()!=null && modtab.getSelectionModel().getSelectedItem()!=null) {
			modtab.getSelectionModel().getSelectedItem().getInstructorso().remove(instructortab.getSelectionModel().getSelectedIndex());
			modtab.getSelectionModel().getSelectedItem().refrech();
		}
	}
	@FXML public void previews(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/Instructors.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
	}
	@FXML public void next(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/ModulesNeeds.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
