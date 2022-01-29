package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InstructorController {
	@FXML public Parent root;
	@FXML public Stage stage;
	@FXML public Scene scene;
	
	@FXML private GridPane avgp=new GridPane();
	
	@FXML private CheckBox cb0=new CheckBox();
	@FXML private CheckBox cb1=new CheckBox();
	@FXML private CheckBox cb2=new CheckBox();
	@FXML private CheckBox cb3=new CheckBox();
	@FXML private CheckBox cb4=new CheckBox();
	@FXML private CheckBox cb5=new CheckBox();
	@FXML private CheckBox cb6=new CheckBox();
	@FXML private CheckBox cb7=new CheckBox();
	@FXML private CheckBox cb8=new CheckBox();
	@FXML private CheckBox cb9=new CheckBox();
	@FXML private CheckBox cb10=new CheckBox();
	@FXML private CheckBox cb11=new CheckBox();
	@FXML private CheckBox cb12=new CheckBox();
	@FXML private CheckBox cb13=new CheckBox();
	@FXML private CheckBox cb14=new CheckBox();
	@FXML private CheckBox cb15=new CheckBox();
	@FXML private CheckBox cb16=new CheckBox();
	@FXML private CheckBox cb17=new CheckBox();
	@FXML private CheckBox cb18=new CheckBox();
	@FXML private CheckBox cb19=new CheckBox();
	@FXML private CheckBox cb20=new CheckBox();
	@FXML private CheckBox cb21=new CheckBox();
	@FXML private CheckBox cb22=new CheckBox();
	@FXML private CheckBox cb23=new CheckBox();
	@FXML private CheckBox cb24=new CheckBox();
	@FXML private CheckBox cb25=new CheckBox();
	@FXML private CheckBox cb26=new CheckBox();
	@FXML private CheckBox cb27=new CheckBox();
	@FXML private CheckBox cb28=new CheckBox();
	@FXML private CheckBox cb29=new CheckBox();
	@FXML private CheckBox cb30=new CheckBox();
	@FXML private CheckBox cb31=new CheckBox();
	@FXML private CheckBox cb32=new CheckBox();
	@FXML private CheckBox cb33=new CheckBox();
	@FXML private CheckBox cb34=new CheckBox();
	@FXML private CheckBox cb35=new CheckBox();
	@FXML private CheckBox cb36=new CheckBox();
	@FXML private CheckBox cb37=new CheckBox();
	@FXML private CheckBox cb38=new CheckBox();
	@FXML private CheckBox cb39=new CheckBox();
	@FXML private CheckBox cb40=new CheckBox();
	@FXML private CheckBox cb41=new CheckBox();
	@FXML private CheckBox cb42=new CheckBox();
	@FXML private CheckBox cb43=new CheckBox();
	@FXML private CheckBox cb44=new CheckBox();
	@FXML private CheckBox cb45=new CheckBox();
	@FXML private CheckBox cb46=new CheckBox();
	@FXML private CheckBox cb47=new CheckBox();
	@FXML private CheckBox cb48=new CheckBox();
	@FXML private CheckBox cb49=new CheckBox();
	@FXML private CheckBox cb50=new CheckBox();
	@FXML private CheckBox cb51=new CheckBox();
	@FXML private CheckBox cb52=new CheckBox();
	@FXML private CheckBox cb53=new CheckBox();
	@FXML private CheckBox cb54=new CheckBox();
	@FXML private CheckBox cb55=new CheckBox();
	
	@FXML private TextField instname=new TextField();
	
	@FXML private JFXButton addinstbut= new JFXButton();
	@FXML private JFXButton refbut= new JFXButton();
	@FXML private JFXButton reminstbut= new JFXButton();
	@FXML private JFXButton nextbut= new JFXButton();
	@FXML private JFXButton previewbut= new JFXButton();
	
	@FXML private TableView<Instructor> instructortab=new TableView<>();
	@FXML private TableColumn<Instructor,String> nameinstcol=new TableColumn<>();
	@FXML private TableColumn<Instructor,Integer> idinstcol=new TableColumn<>();
	
	public void initialize(){
		refbut.setDisable(true);
		CheckBox[][] a= new CheckBox[7][8];
		a[0][0]=cb0;
		a[0][1]=cb7;
		a[0][2]=cb14;
		a[0][3]=cb21;
		a[0][4]=cb28;
		a[0][5]=cb35;
		a[0][6]=cb42;
		a[0][7]=cb49;
		a[1][0]=cb1;
		a[1][1]=cb8;
		a[1][2]=cb15;
		a[1][3]=cb22;
		a[1][4]=cb29;
		a[1][5]=cb36;
		a[1][6]=cb43;
		a[1][7]=cb50;
		a[2][0]=cb2;
		a[2][1]=cb9;
		a[2][2]=cb16;
		a[2][3]=cb23;
		a[2][4]=cb30;
		a[2][5]=cb37;
		a[2][6]=cb44;
		a[2][7]=cb51;
		a[3][0]=cb3;
		a[3][1]=cb10;
		a[3][2]=cb17;
		a[3][3]=cb24;
		a[3][4]=cb31;
		a[3][5]=cb38;
		a[3][6]=cb45;
		a[3][7]=cb52;
		a[4][0]=cb4;
		a[4][1]=cb11;
		a[4][2]=cb18;
		a[4][3]=cb25;
		a[4][4]=cb32;
		a[4][5]=cb39;
		a[4][6]=cb46;
		a[4][7]=cb53;
		a[5][0]=cb5;
		a[5][1]=cb12;
		a[5][2]=cb19;
		a[5][3]=cb26;
		a[5][4]=cb33;
		a[5][5]=cb40;
		a[5][6]=cb47;
		a[5][7]=cb54;
		a[6][0]=cb6;
		a[6][1]=cb13;
		a[6][2]=cb20;
		a[6][3]=cb27;
		a[6][4]=cb34;
		a[6][5]=cb41;
		a[6][6]=cb48;
		a[6][7]=cb55;
		nameinstcol.setCellValueFactory(cellData->cellData.getValue().getInsoName());
		idinstcol.setCellValueFactory(cellData->cellData.getValue().getInsID().asObject());
		instructortab.setItems(Data.instructorso);
		for(int i=0;i<7;i++) {
			for(int o=0;o<8;o++) {
				if(i<Data.daysPerWeek&&o<Data.periodsPerDay) {
					a[i][o].setDisable(false);
				}
				else {
					a[i][o].setDisable(true);
				}
			}
		}
	}
	
	@FXML public void addinstbut(ActionEvent e) {
			if (instname.getText()!=null) {
				ObservableValue<String> s = new SimpleStringProperty(instname.getText());
				Instructor k=new Instructor(s);
				instructortab.getItems().add(k);
				boolean[][] a=new boolean[7][8];
				a[0][0]=cb0.isSelected();
				a[0][1]=cb7.isSelected();
				a[0][2]=cb14.isSelected();
				a[0][3]=cb21.isSelected();
				a[0][4]=cb28.isSelected();
				a[0][5]=cb35.isSelected();
				a[0][6]=cb42.isSelected();
				a[0][7]=cb49.isSelected();
				a[1][0]=cb1.isSelected();
				a[1][1]=cb8.isSelected();
				a[1][2]=cb15.isSelected();
				a[1][3]=cb22.isSelected();
				a[1][4]=cb29.isSelected();
				a[1][5]=cb36.isSelected();
				a[1][6]=cb43.isSelected();
				a[1][7]=cb50.isSelected();
				a[2][0]=cb2.isSelected();
				a[2][1]=cb9.isSelected();
				a[2][2]=cb16.isSelected();
				a[2][3]=cb23.isSelected();
				a[2][4]=cb30.isSelected();
				a[2][5]=cb37.isSelected();
				a[2][6]=cb44.isSelected();
				a[2][7]=cb51.isSelected();
				a[3][0]=cb3.isSelected();
				a[3][1]=cb10.isSelected();
				a[3][2]=cb17.isSelected();
				a[3][3]=cb24.isSelected();
				a[3][4]=cb31.isSelected();
				a[3][5]=cb38.isSelected();
				a[3][6]=cb45.isSelected();
				a[3][7]=cb52.isSelected();
				a[4][0]=cb4.isSelected();
				a[4][1]=cb11.isSelected();
				a[4][2]=cb18.isSelected();
				a[4][3]=cb25.isSelected();
				a[4][4]=cb32.isSelected();
				a[4][5]=cb39.isSelected();
				a[4][6]=cb46.isSelected();
				a[4][7]=cb53.isSelected();
				a[5][0]=cb5.isSelected();
				a[5][1]=cb12.isSelected();
				a[5][2]=cb19.isSelected();
				a[5][3]=cb26.isSelected();
				a[5][4]=cb33.isSelected();
				a[5][5]=cb40.isSelected();
				a[5][6]=cb47.isSelected();
				a[5][7]=cb54.isSelected();
				a[6][0]=cb6.isSelected();
				a[6][1]=cb13.isSelected();
				a[6][2]=cb20.isSelected();
				a[6][3]=cb27.isSelected();
				a[6][4]=cb34.isSelected();
				a[6][5]=cb41.isSelected();
				a[6][6]=cb48.isSelected();
				a[6][7]=cb55.isSelected();
				k.setAvailability(a);				
			}
	}
	@FXML public void reminstbut(ActionEvent e) {
		
			try {
				int a=instructortab.getSelectionModel().getSelectedIndex();
				instructortab.getItems().remove(a);
			} catch (Exception e1) {
				
			}
	}
	@FXML public void previews(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("Rooms and Groups.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void next(ActionEvent e) throws IOException {
		root= FXMLLoader.load(getClass().getResource("Modules.fxml"));
		stage= (Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public Node getnode(int col,int row,GridPane gridpane) {
		Node r=null;
		ObservableList<Node> childrens = gridpane.getChildren();
		for (Node node : childrens) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
	            r = node;
	        }
	    }
		return r;
	}
	@FXML public void hundle() {
		refbut.setDisable(false);
		boolean[][] a=this.instructortab.getSelectionModel().getSelectedItem().getAvailability();
		cb0.setSelected(a[0][0]);
		cb7.setSelected(a[0][1]);
		cb14.setSelected(a[0][2]);
		cb21.setSelected(a[0][3]);
		cb28.setSelected(a[0][4]);
		cb35.setSelected(a[0][5]);
		cb42.setSelected(a[0][6]);
		cb49.setSelected(a[0][7]);
		cb1.setSelected(a[1][0]);
		cb8.setSelected(a[1][1]);
		cb15.setSelected(a[1][2]);
		cb22.setSelected(a[1][3]);
		cb29.setSelected(a[1][4]);
		cb36.setSelected(a[1][5]);
		cb43.setSelected(a[1][6]);
		cb50.setSelected(a[1][7]);
		cb2.setSelected(a[2][0]);
		cb9.setSelected(a[2][1]);
		cb16.setSelected(a[2][2]);
		cb23.setSelected(a[2][3]);
		cb30.setSelected(a[2][4]);
		cb37.setSelected(a[2][5]);
		cb44.setSelected(a[2][6]);
		cb51.setSelected(a[2][7]);
		cb3.setSelected(a[3][0]);
		cb10.setSelected(a[3][1]);
		cb17.setSelected(a[3][2]);
		cb24.setSelected(a[3][3]);
		cb31.setSelected(a[3][4]);
		cb38.setSelected(a[3][5]);
		cb45.setSelected(a[3][6]);
		cb52.setSelected(a[3][7]);
		cb4.setSelected(a[4][0]);
		cb11.setSelected(a[4][1]);
		cb18.setSelected(a[4][2]);
		cb25.setSelected(a[4][3]);
		cb32.setSelected(a[4][4]);
		cb39.setSelected(a[4][5]);
		cb46.setSelected(a[4][6]);
		cb53.setSelected(a[4][7]);
		cb5.setSelected(a[5][0]);
		cb12.setSelected(a[5][1]);
		cb19.setSelected(a[5][2]);
		cb26.setSelected(a[5][3]);
		cb33.setSelected(a[5][4]);
		cb40.setSelected(a[5][5]);
		cb47.setSelected(a[5][6]);
		cb54.setSelected(a[5][7]);
		cb6.setSelected(a[6][0]);
		cb13.setSelected(a[6][1]);
		cb20.setSelected(a[6][2]);
		cb27.setSelected(a[6][3]);
		cb34.setSelected(a[6][4]);
		cb41.setSelected(a[6][5]);
		cb48.setSelected(a[6][6]);
		cb55.setSelected(a[6][7]);		
	}
	@FXML public void refbut(ActionEvent e) {
		boolean[][] a=new boolean[7][8];
		a[0][0]=cb0.isSelected();
		a[0][1]=cb7.isSelected();
		a[0][2]=cb14.isSelected();
		a[0][3]=cb21.isSelected();
		a[0][4]=cb28.isSelected();
		a[0][5]=cb35.isSelected();
		a[0][6]=cb42.isSelected();
		a[0][7]=cb49.isSelected();
		a[1][0]=cb1.isSelected();
		a[1][1]=cb8.isSelected();
		a[1][2]=cb15.isSelected();
		a[1][3]=cb22.isSelected();
		a[1][4]=cb29.isSelected();
		a[1][5]=cb36.isSelected();
		a[1][6]=cb43.isSelected();
		a[1][7]=cb50.isSelected();
		a[2][0]=cb2.isSelected();
		a[2][1]=cb9.isSelected();
		a[2][2]=cb16.isSelected();
		a[2][3]=cb23.isSelected();
		a[2][4]=cb30.isSelected();
		a[2][5]=cb37.isSelected();
		a[2][6]=cb44.isSelected();
		a[2][7]=cb51.isSelected();
		a[3][0]=cb3.isSelected();
		a[3][1]=cb10.isSelected();
		a[3][2]=cb17.isSelected();
		a[3][3]=cb24.isSelected();
		a[3][4]=cb31.isSelected();
		a[3][5]=cb38.isSelected();
		a[3][6]=cb45.isSelected();
		a[3][7]=cb52.isSelected();
		a[4][0]=cb4.isSelected();
		a[4][1]=cb11.isSelected();
		a[4][2]=cb18.isSelected();
		a[4][3]=cb25.isSelected();
		a[4][4]=cb32.isSelected();
		a[4][5]=cb39.isSelected();
		a[4][6]=cb46.isSelected();
		a[4][7]=cb53.isSelected();
		a[5][0]=cb5.isSelected();
		a[5][1]=cb12.isSelected();
		a[5][2]=cb19.isSelected();
		a[5][3]=cb26.isSelected();
		a[5][4]=cb33.isSelected();
		a[5][5]=cb40.isSelected();
		a[5][6]=cb47.isSelected();
		a[5][7]=cb54.isSelected();
		a[6][0]=cb6.isSelected();
		a[6][1]=cb13.isSelected();
		a[6][2]=cb20.isSelected();
		a[6][3]=cb27.isSelected();
		a[6][4]=cb34.isSelected();
		a[6][5]=cb41.isSelected();
		a[6][6]=cb48.isSelected();
		a[6][7]=cb55.isSelected();
		instructortab.getSelectionModel().getSelectedItem().setAvailability(a);
	}
}




