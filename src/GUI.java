import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
//import javafx.application.Application;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
//import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends LostTreasureMain implements Observer {
	Button examine;
	Button button;
	static Stage guiStage = new Stage();
	Label descriptionText;
	Rooms r = new Rooms();
	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		guiStage = primaryStage;
		guiStage.setResizable(false);
		bPane.setCenter(combinedPanes());;
		// Create a scene and place it in the stage
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("The Lost treasure"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setWidth(1040);
		primaryStage.setHeight(585);
		primaryStage.show(); // Display the stage
	}

	private Pane combinedPanes() {
		GridPane pane = new GridPane();
		pane.setHgap(5);	
		//node,column,row
		pane.add(descriptionPane(), 0, 0);
		pane.add(mapPane(), 1, 0);
		pane.add(buttonHPane(), 0, 3);
		pane.add(navButtonPane(), 0, 4);
		pane.add(inventoryPane(), 1, 3);
		pane.add(exitPane(), 2, 5);
		return pane;
	}
	
/*
 * Sets an individual hbox to format where the buttons are located
 * Then the hbox will be added to the main pane
 *
 **/
	private HBox buttonHPane() {
		HBox hBox = new HBox(5);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		examine = new Button("Examine Room");
		Button button2 = new Button("Fight");
		Button button3 = new Button("Flee");
		Button button4 = new Button("View Puzzle");
	
		//moves the button and label in the x direction for placement
		//buttonInventory.setTranslateX(90);
		//health.setTranslateX(100);
		//health.setTranslateY(5);

		hBox.getChildren().add(examine);
		hBox.getChildren().add(button2);
		hBox.getChildren().add(button3);
		hBox.getChildren().add(button4);
		Controller control = new Controller();
		//adds the listener to the button
		control.buttonListener(examine);
		// hBox.getChildren().add(inventoryPane());
		
		return hBox;
	}
	

	private HBox descriptionPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		hBox.setMinWidth(600);
		hBox.setMaxWidth(600);
		descriptionText = new Label();
		descriptionText.setFont(Font.font ("Verdana", 26));
		descriptionText.setWrapText(true);
		hBox.setPadding(new Insets(15, 15, 15, 15));
		hBox.getChildren().add(descriptionText);
		return hBox;
	}
	private HBox mapPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		hBox.setPadding(new Insets(15, 15, 15, 15));
		ImageView imageView = new ImageView(new Image("mapf1.png"));
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		hBox.getChildren().add(imageView);
		return hBox;
	}

	/*
	 *h box that assigns the exit button to an individual panel
	 *assigns a listener to the exit button to close the view
	 * 
	 */
	private HBox inventoryPane(){
		HBox hBox = new HBox(20);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		Button buttonInventory = new Button("Show Inventory");
		Label bag = new Label("Bag: 30/30");
		bag.setFont(Font.font ("Verdana", 20));
		hBox.getChildren().add(buttonInventory);
		hBox.getChildren().add(bag);
		return hBox;
	}
	private HBox navButtonPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		
		hBox.setPadding(new Insets(15, 15, 15, 15));
		Button goButton = new Button("Go!");
		Text text = new Text("Select Room");
		text.setFont(Font.font ("Verdana", 20));

		ComboBox<String> rooms = new ComboBox<>();
		ArrayList<String> roomArray = new ArrayList<>();
		roomArray.add("First Room");
		rooms.getItems().addAll(roomArray);
		hBox.getChildren().add(text);
		hBox.getChildren().add(rooms);
		hBox.getChildren().add(goButton);
		return hBox;
	}
	private HBox exitPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
			    + "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		Button exitButton = new Button("Exit");
		hBox.setPadding(new Insets(15, 15, 15, 15));
		hBox.getChildren().add(exitButton);
		exitButton.setOnAction(e -> {
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});
		return hBox;
	}
//observer, observable methods that will update the gui 


	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(o.countObservers());
		descriptionText.setText(arg.toString());
	}


}
