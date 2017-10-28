import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
	
	private String roomID;
	private String roomName;
	private String roomDescription;
	private boolean puzzle;
	private boolean item;
	private boolean monster;
	private ArrayList<Rooms> roomsArray = new ArrayList<>();

	public Rooms() {
		try {
			roomReader();
		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}
	public Rooms(String roomID, String roomName, String roomDescription, Boolean puzzle, Boolean item, Boolean monster) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.puzzle = puzzle;
		this.item = item;
		this.monster = monster;
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
			Boolean puzzle = Boolean.parseBoolean(reader.nextLine());
			Boolean item = Boolean.parseBoolean(reader.nextLine());
			Boolean monster = Boolean.parseBoolean(reader.nextLine());

			Rooms room = new Rooms( roomID,  roomName, roomDescription, puzzle, item, monster);
			roomsArray.add(room);
		}
		System.out.println("" + roomsArray.get(0).roomDescription);
		System.out.println("" + roomsArray.get(1).monster);
		System.out.println(roomsArray.toString());

	}
	@Override
	public String toString() {
		return roomID + " | " + roomName + " | " + roomDescription + " | " + puzzle + " | " + item + " | " + monster;
	}

	
}
