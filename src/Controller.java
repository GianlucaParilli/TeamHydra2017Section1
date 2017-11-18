
import java.util.ArrayList;
import java.util.function.UnaryOperator;

import javafx.scene.control.Button;

public class Controller {
	Monster monster;
	Commands command;
	Puzzles puzzle = new Puzzles();
	//Monster monster = new Monster();
	Rooms room = new Rooms();
	Login login = new Login();
	Navigation nav = new Navigation();

	public void newGameListener(Button button) {
		Monster monster = new Monster();
		button.setOnAction(e -> {
			// System.out.println("s");
			//monster.printMonster();
			puzzle.ViewPuzzle();
			//monster.ViewMonster();

		});
	}

	public void loadGameListener(Button button) {

		// command = new Commands();
		button.setOnAction(e -> {
			// command.loadGame();
			System.out.println("worked");
		});
	}
	//method that takes a button, then a listener is glued to the button
	//the model's method is called within here
	//model is the Rooms Class

	public void examineRoomListener(Button temp) {
		//System.out.println("examine room");
		temp.setId("r"+room.getRoomID());
		temp.setOnAction(e -> {
			room.addObserver(LostTreasureMain.gui);
			room.ExamineRoom();
			
		});
	}
	public void viewPuzzleListener(Button temp){
		temp.setId(puzzle.getPuzzleDescription());
		temp.setOnAction(e -> {
			puzzle.addObserver(login.gui);
			puzzle.ViewPuzzle();

		});
	}

	public void viewMonsterListener(Button temp){
		temp.setId(monster.getMonsterDescription());
		temp.setOnAction(e -> {
			monster.addObserver(login.gui);
			monster.ViewMonster();

		});
	}
	
//refreshes the map pane
//re populates the drop-down with the available rooms
	public void refreshMap(Button temp){
	
		temp.setOnAction(e->{
			nav.addObserver(login.gui);
			String dropdown = GUI.gui.getRoomsDropDown().getValue();
				
			for(Rooms roomTemp : room.getRoomsArray()){
				if(roomTemp.getRoomName().equals(dropdown)){
					nav.setCurrentRoom(roomTemp.getNumRoomID()); 
					nav.refreshMap(roomTemp.getNumRoomID());
					room.setCurrentRoom(roomTemp.getNumRoomID());
					GUI.gui.getRoomsDropDown().getItems().clear();//clears the previous drop-down
					room.availableRoom(room.getCurrentRoom());//calls the available room method wit the room number that user went to
					//GUI.gui.getRoomsDropDown().getItems().addAll(roomTemp.getRoomIDArray());
					
				}
				
				//
			
			}

			//System.out.println(dropdown);

			room.getCurrentRoom();
		});
	}

}
