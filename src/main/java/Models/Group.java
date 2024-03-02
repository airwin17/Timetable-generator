package application;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Group {
	private static int count=0;
	private ObservableValue<Number> size;
	private ArrayList<Module> moduleneeds=new ArrayList<>();
	private ObservableList<Module> moduleneedso=FXCollections.observableArrayList();
	private ObservableValue<String> namegroup;
	private IntegerProperty id;
	public Group(ObservableValue<Number> a, ObservableValue<String> namegroup) {
		this.id=new SimpleIntegerProperty(count++);
		this.size = a;
		this.namegroup=namegroup;
	}
	public ObservableValue<String> getNamegroup() {
		return namegroup;
	}
	public void setNamegroup(ObservableValue<String> namegroup) {
		this.namegroup = namegroup;
	}
	public int getSize() {
		return size.getValue().intValue();
	}
	public ObservableValue<Number> getoSize() {
		return size;
	}
	public void setSize(ObservableValue<Number> size) {
		this.size = size;
	}
	public ArrayList<Module> getModuleneeds() {
		return moduleneeds;
	}
	public void setModuleneeds(ArrayList<Module> moduleneeds) {
		this.moduleneeds = moduleneeds;
	}
	public IntegerProperty getId() {
		return id;
	}
	public void setId(IntegerProperty id) {
		this.id = id;
	}
	public ObservableList<Module> getModuleneedso() {
		return moduleneedso;
	}
	public void setModuleneedso(ObservableList<Module> moduleneedso) {
		this.moduleneedso = moduleneedso;
	}
	public void refresh() {
		this.moduleneeds.clear();
		this.moduleneeds.addAll(moduleneedso);
	}

}
