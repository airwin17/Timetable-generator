package Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Result {
	private ObservableValue<Number> day;
	private ObservableValue<Number> periode;
	private ObservableValue<Class> class1;
	private ObservableValue<String> groupn;
	private ObservableValue<String> instructor;
	private ObservableValue<String> module;
	private ObservableValue<String> room;
	public Result(Class class1,int day,int peroid) {
		periode=new SimpleIntegerProperty(peroid);
		this.day=new SimpleIntegerProperty(day);
		setGroupn(new SimpleStringProperty(class1.getGroupe().getNamegroup().getValue()));
		setInstructor(new SimpleStringProperty(class1.getInstructor().getInsName()));
		setModule(new SimpleStringProperty(class1.getModule().getModuleName().getValue()));
		setRoom(new SimpleStringProperty(class1.getRoom().getRonb().getValue()));
	}
	private void setGroupn(SimpleStringProperty simpleStringProperty) {
		groupn = simpleStringProperty;
	}
	public ObservableValue<Number> getPeriode() {
		return periode;
	}
	public void setPriode(ObservableValue<Number> priode) {
		this.periode = priode;
	}
	public ObservableValue<Number> getDay() {
		return day;
	}
	public void setDay(ObservableValue<Number> day) {
		this.day = day;
	}
	public ObservableValue<Class> getClass1() {
		return class1;
	}
	public void setClass1(ObservableValue<Class> class1) {
		this.class1 = class1;
	}
	public ObservableValue<String> getInstructor() {
		return instructor;
	}
	public void setInstructor(ObservableValue<String> instructor) {
		this.instructor = instructor;
	}
	public ObservableValue<String> getModule() {
		return module;
	}
	public void setModule(ObservableValue<String> module) {
		this.module = module;
	}
	public ObservableValue<String> getRoom() {
		return room;
	}
	public void setRoom(ObservableValue<String> room) {
		this.room = room;
	}
	public ObservableValue<String> getGroupn() {
		return groupn;
	}

}
