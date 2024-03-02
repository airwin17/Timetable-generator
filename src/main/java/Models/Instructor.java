package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class Instructor {
	private static int count=0;
	private IntegerProperty insID;
	private ObservableValue<String> insName;
	private boolean[][] availability=new boolean[7][8];
	
	public Instructor(ObservableValue<String> insName) {
		this.insID = new SimpleIntegerProperty(count++);
		this.insName = insName;
	}
	public boolean[][] getAvailability() {
		return availability;
	}
	public void setAvailability(boolean[][] availability) {
		this.availability = availability;
	}
	public String getInsName() {
		return insName.getValue();
	}
	public ObservableValue<String> getInsoName() {
		return insName;
	}
	public void setInsName(ObservableValue<String> insName) {
		this.insName = insName;
	}
	public IntegerProperty getInsID() {
		return insID;
	}
	public void setInsID(IntegerProperty insID) {
		this.insID = insID;
	}
	

}
