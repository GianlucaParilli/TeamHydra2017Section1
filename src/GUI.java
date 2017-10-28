import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends LostTreasure implements Observer {
	Button examine;
	static Stage guiStage = new Stage();
	Button button;
	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		guiStage = primaryStage;

		// Place nodes in the pane
		// bPane.setLeft(textPane());
		// bPane.setCenter(BackgroundPane());
		// bPane.setTop(TitlePane());
		// bPane.setBottom(navButtonPane());

		bPane.setTop(topPane());
		bPane.setCenter(buttonHPane());
		bPane.setBottom(exitPane());
		// bPane.setLeft(ButtonPane());
		// Create a scene and place it in the stage
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("The Lost treasure"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setWidth(610);
		primaryStage.setHeight(380);
		primaryStage.show(); // Display the stage

	}

	private Pane ButtonPane() {
		GridPane pane = new GridPane();
		// makes sure that only one is selected
		pane.setHgap(5);
		Button optionButtonUp = new Button("North");
		Button optionButtonDown = new Button("South");
		Button optionButtonLeft = new Button("West");
		Button optionButtonRight = new Button("East");
		Button goButton = new Button("Go!");

		Text text = new Text("Select Room");

		ComboBox<String> rooms = new ComboBox<>();
		ArrayList<String> roomArray = new ArrayList<>();
		roomArray.add("First Room");
		rooms.getItems().addAll(roomArray);

		/*
		 * pane.add(optionButtonUp, 3, 1); pane.add(optionButtonDown, 3, 5);
		 * pane.add(optionButtonLeft, 2, 3); pane.add(optionButtonRight, 4, 3);
		 */

		pane.add(text, 0, 1);
		pane.add(rooms, 1, 1);
		pane.add(goButton, 2, 1);

		return pane;
	}

	private HBox buttonHPane() {
		HBox hBox = new HBox(5);
		examine = new Button("Examine Room");
		Button button2 = new Button("Fight");
		Button button3 = new Button("Flee");
		Button button4 = new Button("View Puzzle");
		Button buttonInventory = new Button("Show Inventory");
		Label health = new Label("Bag: 30/30");

		buttonInventory.setTranslateX(90);
		health.setTranslateX(100);

		health.setTranslateY(5);

		hBox.getChildren().add(examine);
		hBox.getChildren().add(button2);
		hBox.getChildren().add(button3);
		hBox.getChildren().add(button4);
		hBox.getChildren().add(buttonInventory);
		hBox.getChildren().add(health);
		// hBox.getChildren().add(inventoryPane());
		examine.setOnAction(e->{
			Commands commands = new Commands();
			commands.examineRoom(examine.getText());
			Controller control = new Controller();
			control.examineRoom();
		});

		return hBox;
	}
	

	private HBox topPane() {
		HBox hBox = new HBox(15);
		Label text = new Label();
		text.setText("Description");
		hBox.setPadding(new Insets(15, 15, 15, 15));

		hBox.getChildren().add(text);
		ImageView imageView = new ImageView(new Image("mapf1.png"));
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);
		imageView.setTranslateX(300);
		hBox.getChildren().add(imageView);
		return hBox;
	}

	/*
	 * private HBox inventoryPane() { HBox hBox = new HBox(15); Label text = new
	 * Label(); text.setText("the story line goes in this side!!");
	 * hBox.setPadding(new Insets(15, 15, 15, 15));
	 * 
	 * hBox.getChildren().add(text);
	 * 
	 * return hBox; }
	 */
	private HBox exitPane() {
		HBox hBox = new HBox(15);
		Button exitButton = new Button("Exit");
		exitButton.setTranslateX(290);
		// exitButton.setTranslateY(40);

		hBox.setPadding(new Insets(15, 15, 15, 15));
		hBox.getChildren().add(ButtonPane());

		hBox.getChildren().add(exitButton);

		exitButton.setOnAction(e -> {
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});
		return hBox;
	}

@Override
public void update(Observable o, Object arg) {
	String temp = arg.toString();
	System.out.println(temp);
}

}
