package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class Room {
	private static int count=0;
	private IntegerProperty roid;
	private ObservableValue<String> ronb;
	private ObservableValue<Number> roCapacity;
	private ObservableValue<Boolean> rotypeM;
	public Room(ObservableValue<String> ronb, ObservableValue<Number> roCapacity, ObservableValue<Boolean> rotypeM) {
		
		this.roid=new SimpleIntegerProperty(count++);
		this.ronb = ronb;
		this.roCapacity = roCapacity;
		this.rotypeM = rotypeM;
	}
	public IntegerProperty getRoid() {
		return roid;
	}
	public void setRoid(IntegerProperty roid) {
		this.roid = roid;
	}
	public ObservableValue<String> getRonb() {
		return ronb;
	}
	public void setRonb(ObservableValue<String> ronb) {
		this.ronb = ronb;
	}
	public Integer getRoCapacity() {
		return this.roCapacity.getValue().intValue();
	}
	public ObservableValue<Number> getoRoCapacity() {
		return roCapacity;
	}
	public void setRoCapacity(ObservableValue<Number> roCapacity) {
		this.roCapacity = roCapacity;
	}
	public boolean getRotypeM() {
		return rotypeM.getValue();
	}
	public ObservableValue<Boolean> getoRotypeM() {
		return rotypeM;
	}
	public void setRotypeM(ObservableValue<Boolean> rotypeM) {
		this.rotypeM = rotypeM;
	}
	

}
