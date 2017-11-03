
import javafx.scene.control.Button;

public class Controller {
	Monster monster;
	Commands command;
	Rooms room = new Rooms();;
	Login login = new Login();
	//GUI gui = new GUI();
	
	public void newGameListener(Button button) {
		monster = new Monster();
		button.setOnAction(e -> {
			// System.out.println("s");
			monster.printMonster();
		});
	}

	public void loadGameListener(Button button) {

		// command = new Commands();
		button.setOnAction(e -> {
			// command.loadGame();
			System.out.println("worked");
		});
	}

	public void buttonListener(Button temp) {
		//System.out.println("examine room");
		temp.setOnAction(e -> {
			room.addObserver(login.gui);
			room.ExamineRoom();
			///gui.update(room, room.ExamineRoom());
		});
	}

	public void examineRoom() {		
		  room.ExamineRoom();
	}
	

}
