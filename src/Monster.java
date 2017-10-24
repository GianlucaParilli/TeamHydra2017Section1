import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

public class Monster {
	private String name;
	private String description;
	private String health;
	private static ArrayList<Monster> monstersArray = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("monsters");
		Monster m = new Monster();
		m.monsterReader();
	}

	@Override
	public String toString() {
		return name + " | " + description + " | " + health + " | ";
	}

	public Monster() {

	}

	public Monster(String name, String description, String health) {
		this.name = name;
		this.description = description;
		this.health = health;
	}

	public void printMonster() {
		System.out.println("monsters description");
	}
	
//this method reads the text file and make monster object and 
//assigns the name,description and health to the object
	public void monsterReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("monster.txt"));
		;

		while (reader.hasNext()) {
			String name = reader.nextLine();
			String description = reader.nextLine();
			String health = reader.nextLine();

			Monster monster = new Monster(name, description, health);
			monstersArray.add(monster);
		}
		System.out.println("" + monstersArray.get(0).description);
		System.out.println("" + monstersArray.get(1).description);
		System.out.println(monstersArray.toString());

	}

}
