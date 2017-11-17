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

public class GUI extends Login implements Observer {
	Button examine, goButton;
	Button view;
	Button view2;
	static Stage guiStage = new Stage();
	Label descriptionText;
	ImageView mapView;
	Rooms room = new Rooms();
	Monster monsters = new Monster();
	Navigation nav = new Navigation();
	Controller control = new Controller();
	private String character;
	private ComboBox<String> roomsDropDown = new ComboBox<>();
	public void setRoomsDropDown(ComboBox<String> roomsDropDown) {
		this.roomsDropDown = roomsDropDown;
	}

	private String currentPicture = "0";

	public ComboBox<String> getRoomsDropDown() {
		return roomsDropDown;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		guiStage = primaryStage;
		guiStage.setResizable(false);
		bPane.setCenter(combinedPanes());
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
		// node,column,row
		pane.add(descriptionPane(), 0, 0);
		pane.add(mapPane(), 1, 0);
		pane.add(buttonHPane(), 0, 3);
		pane.add(navButtonPane(), 0, 4);
		pane.add(inventoryPane(), 1, 3);
		pane.add(healthPane(), 1, 4);
		pane.add(exitPane(), 2, 5);
		return pane;
		
	}

	/*
	 * Sets an individual hbox to format where the buttons are located Then the
	 * hbox will be added to the main pane
	 *
	 **/
	private HBox buttonHPane() {
		HBox hBox = new HBox(5);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		examine = new Button("Examine Room");
		view =  new Button("View Puzzle");
		view2 = new Button("View Monster");
		
		Button button2 = new Button("Fight");
		Button button3 = new Button("View Monster");
		Button button4 = new Button("View Puzzle");

		hBox.getChildren().add(examine);
		hBox.getChildren().add(view);
		hBox.getChildren().add(view2);
		hBox.getChildren().add(button2);
		
		// adds the listener to the button
		control.examineRoomListener(examine);
		control.viewPuzzleListener(view);
		

//control.viewMonsterListener(view2);
		//System.out.println();
		
		return hBox;
	}

	private HBox descriptionPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		hBox.setMinWidth(600);
		hBox.setMaxWidth(600);
		descriptionText = new Label();
		descriptionText.setFont(Font.font("Verdana", 26));
		descriptionText.setWrapText(true);
		hBox.setPadding(new Insets(15, 15, 15, 15));
		//sets the text from the radio buttons to the description box 
		descriptionText.setText(character);
		hBox.getChildren().add(descriptionText);
		return hBox;
	}

	private HBox mapPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		hBox.setPadding(new Insets(15, 15, 15, 15));
		mapView = new ImageView(new Image("Maps/r" + currentPicture + ".png"));
		mapView.setFitHeight(300);
		mapView.setFitWidth(300);
		hBox.getChildren().add(mapView);
		return hBox;
	}

	public void setCurrentPicture(String currentPicture) {
		this.currentPicture = currentPicture;
	}

	/*
	 * h box that assigns the exit button to an individual panel assigns a
	 * listener to the exit button to close the view
	 * 
	 */
	private HBox inventoryPane() {
		HBox hBox = new HBox(20);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		Button buttonInventory = new Button("Show Inventory");
		Label bag = new Label("Bag: 30/30");
		bag.setFont(Font.font("Verdana", 20));
		hBox.getChildren().add(buttonInventory);
		hBox.getChildren().add(bag);
		return hBox;
	}
	private HBox healthPane() {
		HBox hBox = new HBox(20);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		Label hp = new Label("HP: 100/100");
		hp.setFont(Font.font("Verdana", 20));
		hBox.getChildren().add(hp);
		return hBox;
	}
	private HBox navButtonPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");

		hBox.setPadding(new Insets(15, 15, 15, 15));
		goButton = new Button("Go!");
		Text text = new Text("Select Room");
		text.setFont(Font.font("Verdana", 20));
		roomsDropDown = new ComboBox<>();

		ArrayList<String> roomNameArray = new ArrayList<>();
		//get name from array -- fix
		for(Rooms temp : room.getRoomsArray()){
			roomNameArray.add(temp.getRoomName());
		}
		//roomArray.add("Guards Quarters A");
		//roomArray.add("Guards Quarters B");
		//roomArray.add("Guards Quarters C");
		//roomArray.add("Guards Quarters D");
		//roomArray.add("Guards Quarters E");
		//roomArray.add("Guards Quarters F");
		//roomArray.add("Guards Quarters G");
		//roomArray.add("Guards Quarters H");

		roomsDropDown.getItems().addAll(roomNameArray);
		hBox.getChildren().add(text);
		hBox.getChildren().add(roomsDropDown);
		hBox.getChildren().add(goButton);
		//adds the listener to the go button
		control.refreshMap(goButton);

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
	// observer, observable methods that will update the gui

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof Navigation) {
			// setCurrentPicture(arg.toString());
			System.out.println("update nav "+ arg);
			
			mapView.setImage(new Image("Maps/r" + arg + ".png"));
		} 
		else if (o instanceof Rooms) {
			if(((Rooms) o).hasExaminedRoom(examine.isArmed())){
				descriptionText.setText(arg.toString());
			}else if(((Rooms) o).hasExaminedRoom(goButton.isArmed())){
				System.out.println("f");
			}
			
		}
		else if( o instanceof Puzzles) {
			descriptionText.setText(arg.toString());
			}
	    else if( o instanceof Monster) {
		    descriptionText.setText(arg.toString());
			} 

	}		


		// currentPicture = "01";
	
	}
