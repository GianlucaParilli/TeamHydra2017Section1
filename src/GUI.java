import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Login implements Observer {
	Button examine, goButton, searchRoom, fightMonster, 
	fleeMonster, examineMonster, viewPuzzle, answerPuzzle, pickupItem, hintPuzzle;
	static Stage guiStage = new Stage();
	static Stage inventoryStage = new Stage();
	Label descriptionText;
	ImageView mapView;
	Rooms room = new Rooms();
	Puzzles puzzles = new Puzzles();
	Monster monsters = new Monster();
	Navigation nav = new Navigation();
	Controller control = new Controller();
	private String character;
	private String correctAnswer;
	private ComboBox<String> roomsDropDown = new ComboBox<>();
	private String currentPicture = "0";
    boolean isCorrectAnswerSelected = true;
    boolean isSelected = true;

    
	public ComboBox<String> getRoomsDropDown() {
		return roomsDropDown;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	public void setCorrectAnswer(String correctAnswer){
		this.correctAnswer = correctAnswer;
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
		primaryStage.setHeight(710);
		primaryStage.show(); // Display the stage
	}

	private Pane combinedPanes() {
		GridPane pane = new GridPane();
		pane.setHgap(5);
		// node,column,row
		pane.add(mapPane(), 0, 0);
		pane.add(descriptionPane(), 1, 0);
		pane.add(roomButtonHPane(), 1, 2);
		pane.add(monsterButtonHPane(), 1, 3);
		pane.add(puzzleButtonHPane(), 1, 4);
		pane.add(navButtonPane(), 1, 1);
		pane.add(inventoryPane(), 0, 1);
		pane.add(healthPane(), 0, 2);
		pane.add(exitPane(), 2, 5);
		return pane;

	}

	/*
	 * Sets an individual hbox to format where the buttons are located Then the
	 * hbox will be added to the main pane
	 *
	 **/
	private HBox roomButtonHPane() {
		HBox hBox = new HBox(5);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		searchRoom =  new Button("Search Room");
		examine = new Button("Examine Room");
		pickupItem = new Button("Pickup Item");
		searchRoom.setDisable(true);
		pickupItem.setDisable(true);
		hBox.getChildren().add(examine);
		hBox.getChildren().add(searchRoom);
		hBox.getChildren().add(pickupItem);
		//adding the action listener from the controller class
		control.examineRoomListener(examine);
		control.searchRoomListener(searchRoom);
		control.pickupItemListener(pickupItem);

		return hBox;
	}

	private HBox monsterButtonHPane() {
		HBox hBox = new HBox(5);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");

		examineMonster = new Button("Examine Monster");
		fightMonster =  new Button("Fight Monster");
		fleeMonster = new Button("Flee Monster");

		hBox.getChildren().add(examineMonster);
		hBox.getChildren().add(fightMonster);
		hBox.getChildren().add(fleeMonster);

		// adds the listener to the button
		control.viewMonsterListener(examineMonster);
		control.fleeMonsterListener(fleeMonster);
		control.attactMonsterListener(fightMonster);
		//System.out.println();

		return hBox;
	}



	private HBox puzzleButtonHPane() {
		HBox hBox = new HBox(5);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");

		viewPuzzle = new Button("View Puzzle");
		answerPuzzle = new Button("Answer Puzzle");
		hintPuzzle =  new Button("View Hint");

		hBox.getChildren().add(viewPuzzle);
		hBox.getChildren().add(answerPuzzle);
		hBox.getChildren().add(hintPuzzle);

		control.viewPuzzleListener(viewPuzzle);
		control.viewHintListener(hintPuzzle);
		control.viewAnswerListener(answerPuzzle);

		answerPuzzle.setOnAction(e -> {
			
			Alert popUp = new Alert(AlertType.CONFIRMATION);
			popUp.getDialogPane().setContent(puzzlePopUpPane());
			popUp.setTitle("Answer Puzzle");
			
			Optional<ButtonType> result = popUp.showAndWait();
			ButtonType button = result.orElse(ButtonType.CANCEL);
			
		});
			
		
		return hBox;
	}
	
	private VBox puzzlePopUpPane() {
		VBox vBox = new VBox();
		HBox hBox1 = new HBox(15);
		HBox hBox2 = new HBox(30);
		hBox1.setPadding(new Insets(15, 15, 15, 15));
		//Text input = new Text("Enter User Name");
		//userInput = new TextField();
		//hBox1.getChildren().add(input);
		//hBox1.getChildren().add(userInput);
		vBox.getChildren().add(hBox1);
		hBox2.setPadding(new Insets(15, 15, 15, 15));
		RadioButton StarsButton = new RadioButton("Stars");
		RadioButton TreesButton = new RadioButton("Trees");
		RadioButton FlowersButton = new RadioButton("Flowers");
		RadioButton MountainButton = new RadioButton("Mountain");
	
		
		hBox2.getChildren().add(StarsButton);
		hBox2.getChildren().add(TreesButton );
		hBox2.getChildren().add(FlowersButton);
		hBox2.getChildren().add(MountainButton);
		ToggleGroup toggleGroup = new ToggleGroup();;

		StarsButton.setToggleGroup(toggleGroup);
		TreesButton.setToggleGroup(toggleGroup);
		FlowersButton.setToggleGroup(toggleGroup);
		MountainButton.setToggleGroup(toggleGroup);
		
		MountainButton.setOnAction(e -> {
			LostTreasureMain.gui.descriptionText.setText("correct!");
		
		});
	
		
				
		vBox.getChildren().add(hBox2);
	
		return vBox;

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

	public HBox mapPane() {
		HBox hBox = new HBox(15);
		hBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		hBox.setPadding(new Insets(15, 15, 15, 15));
		mapView = new ImageView(new Image("Maps/r" + currentPicture + ".png"));
		mapView.setFitHeight(300);
		mapView.setFitWidth(300);
		hBox.getChildren().add(mapView);
		//hBox.setVisible(false);
		return hBox;
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
		control.showInventoryListener(buttonInventory);
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
		roomsDropDown.setEditable(true);

		ArrayList<String> roomNameArray = new ArrayList<>();
		//get name from array -- fix
		for(Rooms temp : room.getRoomsArray()){
			roomNameArray.add(temp.getRoomName());
		}

		roomsDropDown.getItems().addAll(roomNameArray);
		roomsDropDown.setPromptText("Entrance Hall");
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
	public void setRoomsDropDown(ComboBox<String> roomsDropDown) {
		this.roomsDropDown = roomsDropDown;
	}
	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof Navigation) {
			//System.out.println("update nav "+ arg);

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


}
