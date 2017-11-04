
import javafx.scene.control.Button;

public class Controller {
	Monster monster;
	Commands command;
	Rooms room = new Rooms();;
	Login login = new Login();
	Navigation nav = new Navigation();
	
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
//method that takes a button, then a listener is glued to the button
//the model's method is called within here
//model is the Rooms Class
	public void buttonListener(Button temp) {
		//System.out.println("examine room");
		temp.setOnAction(e -> {
			room.addObserver(login.gui);
			room.ExamineRoom();
		});
	}

	public void examineRoom() {		
		  room.ExamineRoom();
	}
	public void refreshMap(Button temp){
		temp.setOnAction(e->{
			room.addObserver(login.gui);
			//String room = "";
			System.out.println(GUI.gui.getRoomsDropDown().getValue());
			
			//nav.refreshMap(room);
		});
	}

}
