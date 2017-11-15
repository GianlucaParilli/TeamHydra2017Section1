
import javafx.scene.control.Button;

public class Controller {
	Monster monster;
	Commands command;
	Puzzles puzzle = new Puzzles();
	Rooms room = new Rooms();
	Login login = new Login();
	Navigation nav = new Navigation();

	public void newGameListener(Button button) {
		monster = new Monster();
		button.setOnAction(e -> {
			// System.out.println("s");
			//monster.printMonster();
			puzzle.ViewPuzzle();
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
		temp.setId(""+room.getRoomID());
		temp.setOnAction(e -> {
			room.addObserver(login.gui);
			room.ExamineRoom();
			room.availableRoom();
		});
	}
	public void viewPuzzleListener(Button temp){
		temp.setId(puzzle.getPuzzleDescription());
		temp.setOnAction(e -> {
			puzzle.addObserver(login.gui);
			puzzle.ViewPuzzle();
			//puzzle.ViewPuzzle();
		});
	}

	public void refreshMap(Button temp){
		//temp.setId(GUI.gui.getRoomsDropDown().getId());
		temp.setOnAction(e->{
			nav.addObserver(login.gui);
			//temp.getId();
			String dropdown = GUI.gui.getRoomsDropDown().getValue();
			for(Rooms room : room.getRoomsArray()){
				if(room.getRoomName().equals(dropdown)){
					nav.setCurrentRoom(room.getRoomID()); 
					//GUI.gui.setCurrentPicture(room.getRoomID());
					System.out.println(room.getRoomID());
					nav.refreshMap(room.getRoomID());
				}
			}

			//int roomID = 0; 
			System.out.println(dropdown);

			room.getCurrentRoom();
			//String roomID = "r0" + room.getRoomID();
		});
	}

}
