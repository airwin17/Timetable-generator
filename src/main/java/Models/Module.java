package Models;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Module {
	private static int count=0;
	private ObservableList<Instructor> instructorso=FXCollections.observableArrayList();
	private ArrayList<Instructor> instructors=new ArrayList<>(instructorso.sorted());
    private ObservableValue<String> ModuleName;
    private IntegerProperty id;
    private ObservableValue<Boolean> requiremroommachine;

    public Module(ObservableValue<String> moduleName,ObservableValue<Boolean> requiremroommachine) {
	this.setModuleName(moduleName);
	this.id= new SimpleIntegerProperty(count++);
}

    public ObservableValue<String> getModuleName() {
	return ModuleName;
}

    public void setModuleName(ObservableValue<String> moduleName) {
	ModuleName = moduleName;
}

    public IntegerProperty getId() {
	return id;
}

    public void setId(IntegerProperty id) {
	this.id = id;
}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(ArrayList<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Boolean getRequiremroom() {
		return requiremroommachine.getValue();
	}
	public ObservableValue<Boolean> getoRequiremroom() {
		return requiremroommachine;
	}

	public void setRequiremroom(ObservableValue<Boolean> requiremroom) {
		this.requiremroommachine = requiremroom;
	}
	public ObservableList<Instructor> getInstructorso(){
		return instructorso;
	}
	public void refrech() {
		this.instructors.clear();
		this.instructors.addAll(instructorso);
	}

}
