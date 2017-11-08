public class Items {
	
	protected String itemName;
	protected String itemDescription;
	protected String itemID;
	protected String itemType;
	
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
	
	public void DropItem() { //Placeholder
		
	}
	
	public void ViewItem() { //Placeholder
		
	}
	
	public Items() {
		
	}

	public Items(String itemID, String itemName, String itemDescription, String itemType) {
		setItemID(itemID);
		setItemName(itemName);
		setItemDescription(itemDescription);
		setItemType(itemType);
	}
	
	
	
	
	
	
	

}
