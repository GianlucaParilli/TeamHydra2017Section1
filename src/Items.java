import java.util.ArrayList;

public class Items {
	
	private String itemName;
	private String itemDescription;
	private String itemID;
	private String itemType;
	private static ArrayList<Items> itemsArray = new ArrayList<>();
	
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
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public Items() {
		
	}
	
	public Items(String itemID, String itemName, String itemDescription, String itemType) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
	}
	
	public void DropItem() { //Placeholder
	
	}
	
	public void EquipItem() { //Placeholder
		
	}
	
	public void UnequipItem() { //Placeholder
		
	}
	
	public void UseItem() { //Placeholder
		
	}
	
	public void ViewItem() { //Placeholder
		
	}
	
	
	
	
	
	

}
