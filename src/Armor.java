import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Armor extends Items{

	private int defensePoints;
	private static ArrayList<Armor> armorArray = new ArrayList<>();
	

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	
	public void EquipItem() { //Placeholder
		
	}
	
	public void UnequipItem() { //Placeholder
		
	}
	
	public Armor(String itemID, String itemName, String itemDescription, int defensePoints) {
		setItemID(itemID);
		setItemName(itemName);
		setItemDescription(itemDescription);
		setDefensePoints(defensePoints);
	}
	
	
	
	public static void armorReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("armor.txt"));
		;

		while (reader.hasNext()) {
			String itemID = reader.nextLine();
			String itemName = reader.nextLine();
			String itemDescription = reader.nextLine();
			String defensePoints = reader.nextLine();
			Integer result = Integer.valueOf(defensePoints);
			
			Armor armor = new Armor(itemID, itemName, itemDescription, result);
			armorArray.add(armor);
		}

	}

}
