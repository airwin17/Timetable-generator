package application;

public class Class {
	private Instructor instructor;
	private Group group;
	private Module module;
	private Room room;
	public Class(Room room) {
		this.room = room;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public Group getGroupe() {
		return group;
	}
	public void setGroupe(Group groupe) {
		this.group = groupe;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}

}
