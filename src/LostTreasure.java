import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LostTreasure extends Application{
	 static Stage guiStage = new Stage();

	public void start(Stage primaryStage) throws InterruptedException {	
		guiStage = primaryStage ;

		Stage newStage = new Stage();
		Login login = new Login();
		//GUI gui = new GUI();
		//gui.start(guiStage);
		login.start(newStage);
		
		//Button examine = gui.examine;//login.newGameButton;

		//Button loadGame = login.loadGameButton;
		//Controller control = new Controller();
	    //control.newGameListener(examine);
		//control.loadGameListener(loadGame);
	}
	public static void main(String[] args) throws Exception  {
		launch(args);

	}

}
