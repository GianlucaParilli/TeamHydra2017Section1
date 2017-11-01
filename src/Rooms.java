import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
	
	private String roomID;
	private String roomName;
	private String roomDescription;
	private String exit;
	private String item;
	private String monster;
	private ArrayList<Rooms> roomsArray = new ArrayList<>();

	public Rooms() {
		try {
			roomReader();
		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}
	public Rooms(String roomID, String roomName, String roomDescription, String exit, String monster, String item) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.exit = exit;
		this.monster = monster;
		this.item = item;
	}
	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	public ArrayList<Rooms> getRoomsArray() {
		return roomsArray;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public void EnterRoom() { //Placeholder
		
	}
	
	public void ExamineRoom() { //Placeholder
		
	}
	
	public void ExitRoom() { //Placeholder
		
	}
	
	public void SearchRoom() { //Placeholder
		
	}
	public void roomReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("rooms.txt"));
		;

		while (reader.hasNext()) {
			String roomID = reader.nextLine();
			String roomName = reader.nextLine();
			String roomDescription = reader.nextLine();
			String puzzle = reader.nextLine();
			String item = reader.nextLine();
			String monster = reader.nextLine();

			Rooms room = new Rooms( roomID,  roomName, roomDescription, puzzle, item, monster);
			roomsArray.add(room);
		}
		System.out.println("" + roomsArray.get(0).roomDescription);
		System.out.println("" + roomsArray.get(1).monster);
		System.out.println(roomsArray.toString());

	}
	@Override
	public String toString() {
		return roomID + " | " + roomName + " | " + roomDescription + " | " + exit + " | " + monster + " | " + item;
	}

	
}
