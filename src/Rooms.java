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
	private String availableRoom;
	private String item;
	private String monster;
	private String randomProbability;
	private int numRoomID;
	private int currentRoom;
	private ArrayList<Rooms> roomsArray = new ArrayList<>();
	ArrayList<String> roomIDArray = new ArrayList<>();
	ArrayList<String> roomNameArray = new ArrayList<>();
	
	public ArrayList<String> getRoomIDArray() {
		return roomIDArray;
	}

	public Rooms() {
		try {
			roomReader();
			randomPuzzle();
			
		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}

	public Rooms(String roomID, int numRoomID, String roomName, String roomDescription, String availableRoom, String monster, String item, String randomProbability) {
		this.roomID = roomID;
		this.numRoomID = numRoomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.availableRoom = availableRoom;
		this.monster = monster;
		this.item = item;
		this.randomProbability = randomProbability;
	}

	public void setRoomDescription(String roomDescriptionn) {
		this.roomDescription = roomDescriptionn;
		setChanged();
		notifyObservers(roomDescription);

	}

	public void EnterRoom() { //Placeholder	

	}

	public String ExamineRoom() { //Placeholder
		randomPuzzle();
		setRoomDescription(getRoomsArray().get(getCurrentRoom()).getRoomDescription());
		//System.out.println(roomDescription);
		
		return roomDescription;
	}
	public boolean hasExaminedRoom(boolean bool){
		
		return bool;
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

		while (reader.hasNext()) {
			String roomID = reader.nextLine();
			String digits = roomID.replaceAll("[^0-9.]","");
			int roomNumID =Integer.parseInt(digits);	
			String roomName = reader.nextLine();
			String roomDescription = reader.nextLine();
			String puzzle = reader.nextLine();
			String item = reader.nextLine();
			String monster = reader.nextLine();
			String randomProbability = reader.nextLine();

			Rooms room = new Rooms(roomID, roomNumID, roomName, roomDescription, puzzle, item, monster, randomProbability);
			roomsArray.add(room);
		}
		//System.out.println("" + roomsArray.get(0).roomDescription);
		//System.out.println("" + roomsArray.get(1).monster);
		//System.out.println(roomsArray.get(2).numRoomID);

	}
	public int getNumRoomID() {
		return numRoomID;
	}

	public void setNumRoomID(int numRoomID) {
		this.numRoomID = numRoomID;
	}

	public void availableRoom(int room){
		
		roomNameArray.clear();
		roomIDArray.clear();
		for(Rooms tempAvailable : roomsArray){
			//roomNameArray.clear();
			int tempID = tempAvailable.getNumRoomID();
			if(tempID == room){
				String tempString = tempAvailable.getExit();
				//roomIDArray.clear();
				setCurrentRoom(tempAvailable.numRoomID);
				String[] splitAr = tempString.split(",\\s+");
				for(int i = 0;i<splitAr.length;i++){
						roomIDArray.add(splitAr[i]);
	
					}
				
					Login.gui.getRoomsDropDown().getItems().clear();
					//System.out.println("ddd " + tempAvailable.getExit());
				
			          for(String temp: roomIDArray){
			        	  int replacement = Integer.parseInt(temp.replaceAll("[^0-9.]",""));
							//System.out.println("available rooms "+ roomsArray.get(replacement).roomName );
							roomNameArray.add(roomsArray.get(replacement).roomName);
			        	  												
						}
						 Login.gui.getRoomsDropDown().getItems().addAll(roomNameArray);

				}		
		}	
	}
	
	@Override
	public String toString() {
		return roomID + " | " + roomName + " | " + roomDescription + " | " + availableRoom + " | " + monster + " | " + item + " | " + randomProbability;
	}

	public String getExit() {
		return availableRoom;
	}
	public void setExit(String availableRoom) {
		this.availableRoom = availableRoom;
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
