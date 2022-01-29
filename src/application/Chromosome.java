package application;

import java.util.HashSet;
import java.util.Set;

public class Chromosome {
	private Class[][][] timetable;
	private int fitness;

	public Chromosome() {
		timetable= new Class[Data.daysPerWeek][Data.periodsPerDay][Data.rooms.size()];
	}

	public Class[][][] getTimetable() {
		return timetable;
	}

	public void setTimetable(Class[][][] timetable) {
		this.timetable = timetable;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	public void setClass(int a,int b,int c,Class d) {
		this.timetable[a][b][c].setGroupe(d.getGroupe());
		this.timetable[a][b][c].setModule(d.getModule());
		this.timetable[a][b][c].setInstructor(d.getInstructor());
		this.timetable[a][b][c].setRoom(d.getRoom());
	}
	public void calFitness() {
		
		int fit=0;
		Set<Instructor> seti = new HashSet<>();
		Set<Group> setg=new HashSet<>();
		for(int i =0;i<Data.daysPerWeek;i++) {
			for (int o=0;o<Data.periodsPerDay;o++) {
				for(int p =0;p<Data.rooms.size();p++) {
					try {
						//instructor available
						if(this.getTimetable()[i][o][p].getInstructor().getAvailability()[i][o]==false) {
							fit+=10;
						}
						//size
						if(this.getTimetable()[i][o][p].getRoom().getRoCapacity()<this.getTimetable()[i][o][p].getGroupe().getSize()) {
							fit+=(this.getTimetable()[i][o][p].getGroupe().getSize()-this.getTimetable()[i][o][p].getRoom().getRoCapacity());
						}
						//repeat
						if(seti.add(this.getTimetable()[i][o][p].getInstructor())==false) {
							fit+=20;
						}else {
							seti.add(this.getTimetable()[i][o][p].getInstructor());
						}
						if(setg.add(this.getTimetable()[i][o][p].getGroupe())==false) {
							fit+=20;
						}else {
							setg.add(this.getTimetable()[i][o][p].getGroupe());
						}
						if(this.getTimetable()[i][o][p].getModule().getRequiremroom()!=this.getTimetable()[i][o][p].getRoom().getRotypeM())
							fit+=10;
					} catch (NullPointerException e) {
						
					}
				}
				seti.clear();
				setg.clear();
			}
		}
		this.setFitness(fit);
	}
}

