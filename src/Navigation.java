import java.util.Observable;

public class Navigation extends Observable{
	private int currentRoom=0;
	public void showMap() {
System.out.println("show map method");
	}

	public void hideMap() {

	}

	public void refreshMap(int dropdownString) {
		//tempID = GUI.gui.getRoomsDropDown().getValue(); 
		
		
		System.out.println("refresh map" +  dropdownString);
		setCurrentRoom(dropdownString);
		
	}

	public void setCurrentRoom(int current) {
		this.currentRoom = current;
		setChanged();
		notifyObservers(currentRoom);
		System.out.println("setCurrentRoom" + currentRoom);
	}
}
