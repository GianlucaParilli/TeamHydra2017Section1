import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Monster extends Observable {
	
	private String monsterID;
	private String monsterName;
	private String monsterDescription;
	private String EXP;
	private String damageGiven;
	private String healthPoints;
	private String attackPercentage;
	private String artifactsDropped;
	private int currentRoom = 0;
	private static ArrayList<Monster> monstersArray = new ArrayList<>();
	
	public Monster() {
		try {
			monsterReader();
			ViewMonster();
			
		} catch(FileNotFoundException e){
			System.out.println("No File Found");
		}
	}

	public Monster(String monsterID, String monsterName, String monsterDescription,
			String EXP, String damageGiven, String healthPoints, String attackPercentage, 
			String artifactsDropped)
	{
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterDescription = monsterDescription;
		this.EXP = EXP;
		this.damageGiven = damageGiven;
		this.healthPoints = healthPoints;
		this.attackPercentage = attackPercentage;
		this.artifactsDropped = artifactsDropped;
	}
	
	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
		setChanged();
		notifyObservers(monsterDescription);
	}
	
	public String ViewMonster() {
		try{
			setMonsterDescription(getMonstersArray().get(getCurrentRoom()).getMonsterDescription());
			currentRoom++;
			
		}catch(Exception e){
			System.out.println(monsterDescription);
		}
		return monsterDescription;
		
	}
	
	
	public void monsterReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("monster.txt"));
		;

		while(reader.hasNext()){
			String monsterID = reader.nextLine();
			String monsterName = reader.nextLine();
			String monsterDescription= reader.nextLine();
			String EXP = reader.nextLine();
			String damageGiven = reader.nextLine();
			String healthPoints = reader.nextLine();
			String attackPercentage = reader.nextLine();
			String artifactsDropped = reader.nextLine();

			Monster monster = new Monster( monsterID, monsterName, monsterDescription, EXP, 
					damageGiven, healthPoints, attackPercentage, artifactsDropped);
			monstersArray.add(monster);
		}
	}


	public String toString() {
		return monsterID + " | " + monsterDescription + " | " + EXP + " | " + damageGiven + " | " + healthPoints + "|" +
				attackPercentage + "|" + artifactsDropped + "|";
	}

	public String getMonsterID() {
		return monsterID;
	}

	public void setMonsterID(String monsterID) {
		this.monsterID = monsterID;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMonsterDescription() {
		return monsterDescription;
	}

	public String getEXP() {
		return EXP;
	}

	public void setEXP(String eXP) {
		EXP = eXP;
	}

	public String getDamageGiven() {
		return damageGiven;
	}

	public void setDamageGiven(String damageGiven) {
		this.damageGiven = damageGiven;
	}

	public String getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(String healthPoints) {
		this.healthPoints = healthPoints;
	}

	public String getAttackPercentage() {
		return attackPercentage;
	}

	public void setAttackPercentage(String attackPercentage) {
		this.attackPercentage = attackPercentage;
	}

	public String getArtifactsDropped() {
		return artifactsDropped;
	}

	public void setArtifactsDropped(String artifactsDropped) {
		this.artifactsDropped = artifactsDropped;
	}
	
	
	public int getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
		
	}
	
	public ArrayList<Monster> getMonstersArray() {
		return monstersArray;
	}



	
}
