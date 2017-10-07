import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends GUI{
	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		bPane.setCenter(vpane());
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("The Lost Treasure"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setWidth(240);
		primaryStage.setHeight(300);
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage
	}

//adds all the buttons to a V box 
//sets the text for the buttons
//adds the topPane method(picture) to the v pane 
//sets all the listeners for the buttons
	private VBox vpane(){
		VBox vpane = new VBox();
		Button newGameButton = new Button("  New Game  ");
	    Button loadGameButton = new Button("  Load  ");
	    Button exitButton = new Button("  Exit  ");
	    newGameButton.setTranslateX(70);
	    loadGameButton.setTranslateX(87);
	    exitButton.setTranslateX(91);
		vpane.getChildren().add(topPane());
		vpane.getChildren().add(newGameButton);
		vpane.getChildren().add(loadGameButton);
		vpane.getChildren().add(exitButton);
		
		newGameButton.setOnAction(e ->{
			 GUI newGame = new GUI();
			 try {
				newGame.start(guiStage);
				//remember to close previous stage
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		exitButton.setOnAction(e -> {
			//quits and closes the gui 
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});

		return vpane;
	}
//add an image view into a H box 
//sets image size and placement inside the hbox
	private HBox topPane() {
	    HBox hBox = new HBox(15);
	    hBox.setPadding(new Insets(15, 15, 15, 15));
	    ImageView imageView = new ImageView(new Image("logo.png"));
	    imageView.setFitHeight(130);
	    imageView.setFitWidth(130);
	    imageView.setTranslateX(40);
	    hBox.getChildren().add(imageView);
	    return hBox;
	  }
	

	public static void main(String[] args) {
		launch(args);
	}
	

}
