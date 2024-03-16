package controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import Models.Module;
import Models.Data;
import Models.Group;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ModuleNeedController {
	@FXML public Parent root;
	@FXML public Stage stage;
	@FXML public Scene scene;
	
	@FXML private JFXButton addmodbut =new JFXButton();
	@FXML private JFXButton remmodbut =new JFXButton();
	@FXML private JFXComboBox<Module> modcb=new JFXComboBox<>();
	
	@FXML private TableView<Group> grouptab=new TableView<>();
	@FXML private TableColumn<Group,Integer> idgroupcol=new TableColumn<>();
	@FXML private TableColumn<Group,String> groupcol=new TableColumn<>();
	
	@FXML private TableView<Module> modtab=new TableView<>();
	@FXML private TableColumn<Module,Integer> idmodcol=new TableColumn<>();
	@FXML private TableColumn<Module,String> modcol=new TableColumn<>();
	
	@FXML public void initialize() {
		idgroupcol.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
		groupcol.setCellValueFactory(cellData ->cellData.getValue().getNamegroup());
		grouptab.setItems(Data.groupo);
		
	}
	@FXML public void hundle() {
		idmodcol.setCellValueFactory(cellData->cellData.getValue().getId().asObject());
		modcol.setCellValueFactory(cellData->cellData.getValue().getModuleName());
		modtab.setItems(grouptab.getSelectionModel().getSelectedItem().getModuleneedso());
		modcb.setItems(Data.moduleo);
		modcb.setConverter(new StringConverter<Module>() {

			@Override
			public Module fromString(String s) {
				Module k=null;
				for(int i=0;i<Data.moduleo.size();i++) {
					if(s.equals(Data.moduleo.sorted().get(i).getModuleName().getValue())) {
						k=Data.moduleo.sorted().get(i);
					}
				}
				return k;
			}

			@Override
			public String toString(Module i) {
				
				return i.getModuleName().getValue();
			}
			
		});
	}
	@FXML public void previews(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/Modules.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void next(ActionEvent e) throws IOException {
		
		root= FXMLLoader.load(getClass().getResource("/Result.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void addmodneed(ActionEvent e) {
		if(this.grouptab.getSelectionModel().getSelectedItem()!=null&&this.modcb.getSelectionModel().getSelectedItem()!=null) {
			this.grouptab.getSelectionModel().getSelectedItem().getModuleneedso().add(this.modcb.getSelectionModel().getSelectedItem());
			this.grouptab.getSelectionModel().getSelectedItem().refresh();
		}
	}
	@FXML public void remmodneed(ActionEvent e) {
		if(this.modtab.getSelectionModel().getSelectedItem()!=null) {
			this.grouptab.getSelectionModel().getSelectedItem().getModuleneedso().remove(this.modtab.getSelectionModel().getSelectedIndex());
			this.grouptab.getSelectionModel().getSelectedItem().refresh();
		}
	}

}
