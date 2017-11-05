import java.util.Observable;

public class Navigation extends Observable{
	private String currentRoom;
	public void showMap() {
System.out.println("show map method");
	}

	public void hideMap() {

	}

	public void refreshMap(String dropdownString) {
		//tempID = GUI.gui.getRoomsDropDown().getValue(); 
		
		
		System.out.println("refresh map" +  dropdownString);
		setCurrentRoom(dropdownString);
	}

	public void setCurrentRoom(String current) {
		this.currentRoom = current;
		setChanged();
		notifyObservers(currentRoom);
	}
}
