import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

/**
 * @author Humberto Michael Lopez
 * @version 1.0 
 * @Course : ITEC 3860, Fall, 2017 Written: November 8, 2017
 *  
 */

public class Items extends Observable {

	private String itemID;
	private String itemDescription;
	private String itemType;
	private String itemUsage;
	private String itemStrength;
	private static ArrayList<Items> itemsArray = new ArrayList<>();
	

	public Items( String itemID, String itemDescription, String itemType, String itemUsage, String itemStrength ){
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemUsage = itemUsage;
		this.itemStrength = itemStrength;
		
	}
	
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
		setChanged();
		notifyObservers(itemDescription);
	}


	String viewItems(int currentRoom){
		System.out.println(currentRoom);
		setItemDescription(getitemsArray().get(currentRoom).getItemDescription());
		return itemDescription;
	}


	public void itemsReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("artifacts.txt"));
		;

		while(reader.hasNext()){
			String itemID = reader.nextLine();
			String itemDescription = reader.nextLine();
			String itemType = reader.nextLine();
			String itemUsage = reader.nextLine();
			String itemStrength = reader.nextLine();

			Items items = new Items(itemID, itemDescription, itemType, itemUsage, itemStrength);
			itemsArray.add(items);
		}
	}

	private ArrayList<Items> getitemsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemID() {
		return itemID;
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

}