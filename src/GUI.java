import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application{
	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		// Place nodes in the pane
		//bPane.setLeft(textPane());
		//bPane.setCenter(BackgroundPane());
		//bPane.setTop(TitlePane());
		//bPane.setBottom(navButtonPane());
		
		bPane.setTop(topPane());
		bPane.setCenter(buttonHPane());
		bPane.setBottom(bottomPane());
       // bPane.setLeft(ButtonPane());
		// Create a scene and place it in the stage
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("Text-Based Game"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setWidth(720);
		primaryStage.setHeight(420);
		primaryStage.show(); // Display the stage

	}

	private Pane ButtonPane() {
		GridPane pane = new GridPane();
		// makes sure that only one is selected
		Button optionButtonUp = new Button("North");
		Button optionButtonDown = new Button("South");
		Button optionButtonLeft = new Button("West");
		Button optionButtonRight = new Button("East");

		pane.add(optionButtonUp, 3, 1);
		pane.add(optionButtonDown, 3, 5);
		pane.add(optionButtonLeft, 2, 3);
		pane.add(optionButtonRight, 4, 3);
		return pane;
	}

	private HBox buttonHPane() {
	    HBox hBox = new HBox(5);
	    Button button1 = new Button("Examine Room");
		Button button2 = new Button("Fight");
		Button button3 = new Button("Flee");
		Button button4 = new Button("something");
		Button buttonInventory = new Button("Show Inventory");
		Label health = new Label("Health: 30/30 HP");

		buttonInventory.setTranslateX(150);
		health.setTranslateX(150);
		
		health.setTranslateY(5);
		
	    hBox.getChildren().add(button1);
	    hBox.getChildren().add(button2);
	    hBox.getChildren().add(button3);
	    hBox.getChildren().add(button4);
	    hBox.getChildren().add(buttonInventory);
	    hBox.getChildren().add(health);
	    //hBox.getChildren().add(inventoryPane());


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
	    imageView.setTranslateX(400);
	    hBox.getChildren().add(imageView);
	    return hBox;
	  }
	private HBox inventoryPane() {
	    HBox hBox = new HBox(15);
	    Label text = new Label();
	  	text.setText("the story line goes in this side!!");
	    hBox.setPadding(new Insets(15, 15, 15, 15));
	    
	    hBox.getChildren().add(text);
	    
	    return hBox;
	  }
	private HBox bottomPane() {
	    HBox hBox = new HBox(15);
	    Button exitButton = new Button("  Exit  ");
	    exitButton.setTranslateX(400);
	    exitButton.setTranslateY(40);
		
	    hBox.setPadding(new Insets(15, 15, 15, 15));
	    hBox.getChildren().add(ButtonPane());

	    hBox.getChildren().add(exitButton);
	    
	    exitButton.setOnAction(e -> {
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});
	    return hBox;
	  }

	

	public static void main(String[] args) {
		launch(args);
	}
	

}
