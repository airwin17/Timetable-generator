package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Data {
	public static ObservableList<Instructor> instructorso=FXCollections.observableArrayList();
	public static ArrayList<Instructor> instructors=new ArrayList<>(instructorso.sorted());
	
	public static ObservableList<Group> groupo=FXCollections.observableArrayList();
	public static ArrayList<Group> groups=new ArrayList<>(groupo.sorted());
	
	public static ObservableList<Module> moduleo=FXCollections.observableArrayList();
	public static ArrayList<Module> module=new ArrayList<>(moduleo.sorted());
	
	public static int periodsPerDay;
	public static int daysPerWeek;
	
	public static ObservableList<Room> roomso=FXCollections.observableArrayList();
	public static ArrayList<Room> rooms=new ArrayList<>(roomso.sorted());
	
	public static ObservableList<Result> result=FXCollections.observableArrayList();
	public static void refresh() {
		rooms.addAll(roomso);
		groups.addAll(groupo);
		instructors.addAll(instructorso);
		module.addAll(moduleo);
		for(int i=0;i<Data.module.size();i++) {
			Data.module.get(i).refrech();
		}
	}
	public static void result(Chromosome s) {
		for (int i=0;i<Data.daysPerWeek;i++) {
			for(int o=0;o<Data.periodsPerDay;o++) {
				for(int p=0;p<Data.rooms.size();p++) {
					Data.result.add(new Result(s.getTimetable()[i][o][p], i, o));
				}
			}
		}
	}

}
