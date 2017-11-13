import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
//import java.util.Random;
import java.util.Scanner;


public class Puzzles extends Observable {

	private String puzzleID;
	private String puzzleDescription;
	private String puzzleAnswer;
	private String puzzleHint;
	//private String numAttempts = 0;
	private int currentRoom = 0;
	private static ArrayList<Puzzles> puzzlesArray = new ArrayList<>();
	

	public Puzzles() {
		try {
			puzzleReader();
			ViewPuzzle();

		} catch(FileNotFoundException e){
			System.out.println("No File Found");
		}
	}

	public void setpuzzleDescription(String puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
		setChanged();
		notifyObservers(puzzleDescription);
	}

	public void puzzleReader() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new File("puzzle.txt"));
		;

		while(reader.hasNext()){

			String puzzleID = reader.nextLine();
			String puzzleDescription = reader.nextLine();
			String puzzleAnswer = reader.nextLine();
			String puzzleHint = reader.nextLine();


			Puzzles puzzle = new Puzzles(puzzleID, puzzleDescription, puzzleAnswer, puzzleHint);
			puzzlesArray.add(puzzle);

		}
	}

	public Puzzles(String puzzleID, String puzzleDescription, String puzzleAnswer, String puzzleHint)
	{
		this.puzzleID = puzzleID;
		this.puzzleDescription = puzzleDescription;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleHint = puzzleHint;
		//this.numAttempts = numAttempts;
	}

	// called in the Controller class 
	public void testMethod (){
		System.out.println("test");
	}


	public String ViewPuzzle() { //Placeholder
		//randomPuzzle();
		//room.getStartRoom(); //0 
		setPuzzleDescription(getPuzzlesArray().get(getCurrentRoom()).getPuzzleDescription());
		System.out.println(puzzleDescription);
		currentRoom++;
		
		return puzzleDescription;
	}
	

	/*private int currentRoom() {
		// TODO Auto-generated method stub
		return 0;
	}
*/

	private ArrayList<Puzzles> getPuzzlesArray() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPuzzleID() {
		return puzzleID;
	}


	public void setPuzzleID(String puzzleID) {
		this.puzzleID = puzzleID;
	}


	public String getPuzzleDescription() {
		return puzzleDescription;
	}


	public void setPuzzleDescription(String puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
	}


	public String getPuzzleAnswer() {
		return puzzleAnswer;
	}


	public void setPuzzleAnswer(String puzzleAnswer) {
		this.puzzleAnswer = puzzleAnswer;
	}


	public String getPuzzleHint() {
		return puzzleHint;
	}


	public void setPuzzleHint(String puzzleHint) {
		this.puzzleHint = puzzleHint;
	}

	public ArrayList<Puzzles> getRoomsArray() {
		return puzzlesArray;
	}

	/*public int getNumAttempts() {
		return numAttempts;
	}

	 */
	/*	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}

	 */
	public int getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}


	public void printPuzzle() {
		System.out.println("puzzle");
		
	}

}
