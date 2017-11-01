
import javafx.scene.control.Button;

public class Controller {
	Monster monster;
	Commands command;
	Rooms room = new Rooms();;
	Login login = new Login();

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
		System.out.println("examine room");
		temp.setOnAction(e -> {
			System.out.println("dddd");
		});
	}

	public void examineRoom() {
		//room = new Rooms();
		
		System.out.println(""+ room.getRoomsArray().size());
		room.randomPuzzle();
	}
	

}
