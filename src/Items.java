import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * @author Humberto Michael Lopez
 * @version 1.0 
 * @Course : ITEC 3860, Fall, 2017 Written: November 8, 2017
 *  
 */

public class Items extends Observable {

	private String itemID;
	private String itemName;
	private String itemDescription;
	private String itemType;
	private String itemUsage;
	private String itemStrength;
	private static ArrayList<Items> itemsArray = new ArrayList<>();
	public static ArrayList<String> inventory = new ArrayList<>();
	

	public Items( String itemID, String itemName, String itemDescription, String itemType, String itemUsage, String itemStrength ){
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemUsage = itemUsage;
		this.itemStrength = itemStrength;
		
	}
	
	public Items() {
		try {
			itemsReader();
		} catch (FileNotFoundException e) {
			System.out.println("No File Found");
		}
	}
	
	public void inventoryPopUp(ArrayList<String> inventoryArray) {
		Alert popUp = new Alert(AlertType.INFORMATION);
		popUp.setTitle("Inventory");
		popUp.setHeaderText("Select an item");
		ImageView logo = new ImageView("logo.png");
		logo.setFitWidth(64);
	    logo.setFitHeight(64);
		popUp.setGraphic(logo);
		VBox pop = new VBox();
		pop.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 1;"
				+ "-fx-border-insets: 10;" + "-fx-border-radius: 10;" + "-fx-border-color: black;");
		pop.setPadding(new Insets(50, 50, 50, 50));
		RadioButton cb; 
		ToggleGroup toggleGroup = new ToggleGroup();

		for (String temp : inventoryArray) {
			cb = new RadioButton(temp);
			cb.setFont(Font.font("Verdana", 16));

			cb.setToggleGroup(toggleGroup);
			pop.getChildren().add(cb);
			if (temp.equals(cb.getText())) {
				cb.setOnAction(e -> {
					System.out.println(temp);
				});
			}
		}
		popUp.getDialogPane().setContent(pop);
		popUp.show();
	}
	public void equipItem() {
		
	}
	
	public void unequipItem() {
		
	}
	
	public void useItem() {
		
	}
	
	public boolean unlockDoor() {
		return false;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
		setChanged();
		notifyObservers(itemDescription);
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
		setChanged();
		notifyObservers(itemName);
	}


	public String viewItems(int currentRoom){
		System.out.println(getitemsArray().get(currentRoom).getItemName());
		setItemDescription(getitemsArray().get(currentRoom).getItemName());
		return itemDescription;
	}


	public void itemsReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("artifact.txt"));
		

		while(reader.hasNext()){
			String itemID = reader.nextLine();
			String itemName = reader.nextLine();
			String itemDescription = reader.nextLine();
			String itemType = reader.nextLine();
			String itemUsage = reader.nextLine();
			String itemStrength = reader.nextLine();

			Items items = new Items(itemID, itemName, itemDescription, itemType, itemUsage, itemStrength);
			itemsArray.add(items);
		}
	}

	private ArrayList<Items> getitemsArray() {
		return itemsArray;
	}

	public String getItemID() {
		return itemID;
	}
	
	public  ArrayList<String> getInventory() {
		return inventory;
	}

	public  void setInventory(ArrayList<String> inventory) {
		Items.inventory = inventory;
	}
	
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemDescription() {
		return itemDescription;
	}


	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemUsage() {
		return itemUsage;
	}

	public void setItemUsage(String itemUsage) {
		this.itemUsage = itemUsage;
	}

	public String getItemStrength() {
		return itemStrength;
	}

	public void setItemStrength(String itemStrength) {
		this.itemStrength = itemStrength;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	@Override
	public String toString() {
		return itemDescription;
		
	}
}