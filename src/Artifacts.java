import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Humberto Michael Lopez
 * @version 1.0 
 * @Course : ITEC 3860, Fall, 2017 Written: November 8, 2017
 *  
 */

public class Artifacts extends Items{
	
	private static ArrayList<Artifacts> artifactsArray = new ArrayList<>();
		
	
	
	public Artifacts(String itemID, String itemName, String itemDescription) {
		setItemID(itemID);
		setItemName(itemName);
		setItemDescription(itemDescription);
	}
	
	public static void artifactsReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("artifacts.txt"));
		;

		while (reader.hasNext()) {
			String itemID = reader.nextLine();
			String itemName = reader.nextLine();
			String itemDescription = reader.nextLine();
			
			Artifacts artifacts = new Artifacts(itemID, itemName, itemDescription);
			artifactsArray.add(artifacts);
		}
		
	}

}
