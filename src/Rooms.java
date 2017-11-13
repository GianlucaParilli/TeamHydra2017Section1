import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

public class Rooms extends Observable {

	private String roomID;
	private String roomName;
	private String roomDescription;
	private String exit;
	private String item;
	private String monster;
	private String randomProbability;
	private int currentRoom = 0;
	private ArrayList<Rooms> roomsArray = new ArrayList<>();

	public Rooms() {
		try {
			roomReader();
			randomPuzzle();

		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}

	public Rooms(String roomID, String roomName, String roomDescription, String exit, String monster, String item, String randomProbability) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.exit = exit;
		this.monster = monster;
		this.item = item;
		this.randomProbability = randomProbability;
	}

	public void setRoomDescription(String roomDescriptionn) {
		this.roomDescription = roomDescriptionn;
		setChanged();
		notifyObservers();

	}

	public void EnterRoom() { //Placeholder	

	}

	public String ExamineRoom() { //Placeholder
		randomPuzzle();
		//room.getStartRoom(); //0 
		setRoomDescription(getRoomsArray().get(getCurrentRoom()).getRoomDescription());
		System.out.println(roomDescription);
		currentRoom++;

		return roomDescription;
	}
	public void ExitRoom() { //Placeholder

	}
	public void SearchRoom() { //Placeholder

	}
	public void randomPuzzle(){
		Random rand = new Random();

		for(Rooms temp : roomsArray){
			int randomProb = Integer.parseInt(temp.randomProbability);
			//finds room with prob higher than 0, if greater than 0, randomize puzzle.
			if(randomProb >0){
				//System.out.println(rand.nextInt(randomProb) + 1);
				temp.setMonster("" +rand.nextInt(randomProb) + 1);
			}
		}
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
			String randomProbability = reader.nextLine();

			Rooms room = new Rooms( roomID,  roomName, roomDescription, puzzle, item, monster, randomProbability);
			roomsArray.add(room);
		}
		//System.out.println("" + roomsArray.get(0).roomDescription);
		//System.out.println("" + roomsArray.get(1).monster);
		//System.out.println(roomsArray.toString());

	}
	@Override
	public String toString() {
		return roomID + " | " + roomName + " | " + roomDescription + " | " + exit + " | " + monster + " | " + item + " | " + randomProbability;
	}

	public String getExit() {
		return exit;
	}
	public void setExit(String exit) {
		this.exit = exit;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getMonster() {
		return monster;
	}
	public void setMonster(String monster) {

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
	public int getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}
}
