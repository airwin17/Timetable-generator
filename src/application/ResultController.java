package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultController {
	@FXML private TableView<Result> classtab=new TableView<>();
	@FXML private TableColumn<Result,Number> daycol=new TableColumn<>();
	@FXML private TableColumn<Result,Number> periodcol=new TableColumn<>();
	@FXML private TableColumn<Result,String> roomcol=new TableColumn<>();
	@FXML private TableColumn<Result,String> groupcol=new TableColumn<>();
	@FXML private TableColumn<Result,String> modulecol=new TableColumn<>();
	@FXML private TableColumn<Result,String> instructorcol=new TableColumn<>();
	@FXML private JFXButton generate =new JFXButton();
	
	@FXML private void initialize() {
		Data.refresh();
		
		daycol.setCellValueFactory(cellData->cellData.getValue().getDay());
		periodcol.setCellValueFactory(cellData->cellData.getValue().getPeriode());
		roomcol.setCellValueFactory(cellData->cellData.getValue().getRoom());
		groupcol.setCellValueFactory(cellData->cellData.getValue().getGroupn());
		modulecol.setCellValueFactory(cellData->cellData.getValue().getModule());
		instructorcol.setCellValueFactory(cellData->cellData.getValue().getInstructor());
		classtab.setItems(Data.result);
		
	}
	@FXML public void generator(ActionEvent e) {
		Population pop=new Population(50);
		while(pop.selection()[0].getFitness()!=0){
			
			pop.nextgen();
		}
		for (int i=0;i<Data.daysPerWeek;i++) {
			for(int o=0;o<Data.periodsPerDay;o++) {
				for(int p=0;p<Data.rooms.size();p++) {
					if (pop.selection()[0].getTimetable()[i][o][p].getGroupe()!=null) {
						Data.result.add(new Result(pop.selection()[0].getTimetable()[i][o][p], i, o));
					}
				}
			}
		}
	}
}

