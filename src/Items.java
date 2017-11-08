/**
 * @author Humberto Michael Lopez
 * @version 1.0 
 * @Course : ITEC 3860, Fall, 2017 Written: November 8, 2017
 *  
 */

public class Items {
	
	protected String itemName;
	protected String itemDescription;
	protected String itemID;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	
	public void pickupItem() {
		
	}
	
	public void dropItem() { //Placeholder
		
	}
	
	public String viewItem() { //Placeholder
		return getItemDescription();
	}
	
	public Items() {
		
	}

	public Items(String itemID, String itemName, String itemDescription) {
		setItemID(itemID);
		setItemName(itemName);
		setItemDescription(itemDescription);
	}

}
