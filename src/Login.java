import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends GUI {
	TextField userInput;
	protected ArrayList<String> usernamesArray = new ArrayList<>();
	protected ArrayList<Button> arrayButtons = new ArrayList<>();
	

	public void start(Stage primaryStage) throws InterruptedException {
		BorderPane bPane = new BorderPane();
		bPane.setCenter(mainPane());

		// Create a scene and place it in the stage
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("The Lost Treasure"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setWidth(240);
		primaryStage.setHeight(300);
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage
	}

	// adds all the buttons to a V box
	// sets the text for the buttons
	// adds the topPane method(picture) to the v pane
	// sets all the listeners for the buttons
	private VBox mainPane() {
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

		newGameButton.setOnAction(e -> {

			Alert popUp = new Alert(AlertType.CONFIRMATION);
			popUp.getDialogPane().setContent(popUpPane());
			popUp.setTitle("Results");
			Optional<ButtonType> result = popUp.showAndWait();
			ButtonType button = result.orElse(ButtonType.CANCEL);

			if (button == ButtonType.OK) {
				String usernameString = userInput.getText();

				for(int i = usernamesArray.size()-1; i>0 ; i--){//String temp: usernamesArray){
					if(usernamesArray.get(i).equals(userInput.getText())){
						//usernamesArray.remove(usernamesArray.size()-1);
						System.out.println("error duplicate");
					    usernamesArray.remove(userInput.getText());
						//break;
						
						
					}
					
				}
				usernamesArray.add(usernameString);


				writer(usernamesArray);
				/*
				 * GUI newGame = new GUI(); try { newGame.start(guiStage); //
				 * remember to close previous stage } catch
				 * (InterruptedException e1) { // TODO Auto-generated catch
				 * block e1.printStackTrace(); }
				 */
			} else {
				System.out.println("canceled");
			}

		});
		loadGameButton.setOnAction(e -> {
			if (usernamesArray.size() == 0) {
				Alert errorPopUp = new Alert(AlertType.ERROR);
				errorPopUp.setHeaderText("there are no saved profiles");
				errorPopUp.show();
			} else {
				loadPopUp(usernamesArray);

			}
		});
		exitButton.setOnAction(e -> {
			// quits and closes the gui
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
		});

		return vpane;
	}

	private void loadPopUp(ArrayList<String> userStringtemp) {
		Alert popUp = new Alert(AlertType.INFORMATION);
		popUp.setTitle("Load Game");
		VBox pop = new VBox();
		pop.setPadding(new Insets(20, 20, 20, 20));
		Button b = new Button();

		for (String temp : userStringtemp) {
			b = new Button(temp);
			pop.getChildren().add(b);
			if(temp.equals(b.getText())){
				b.setOnAction(e->{
				System.out.println(temp);
			});
			}
			
		}
		popUp.getDialogPane().setContent(pop);

		popUp.show();
	}

	// add an image view into a H box
	// sets image size and placement inside the hbox
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

	private VBox popUpPane() {
		VBox vBox = new VBox();
		// organizes the form into a h box within a v box
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15, 15, 15, 15));
		Text input = new Text("Enter User Name");
		userInput = new TextField();
		hBox.getChildren().add(input);
		hBox.getChildren().add(userInput);
		vBox.getChildren().add(hBox);

		return vBox;

	}

	public void writer(ArrayList<String> array) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("usernameSave.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		for (String temp : array) {
			writer.println(temp);
		}
		writer.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
