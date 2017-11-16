import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
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

	public Puzzles(String puzzleID, String puzzleDescription, String puzzleAnswer, String puzzleHint)
	{
		this.puzzleID = puzzleID;
		this.puzzleDescription = puzzleDescription;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleHint = puzzleHint;
		//this.numAttempts = numAttempts;
	}
	
	public void setPuzzleDescription(String puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
		setChanged();
		notifyObservers(puzzleDescription);
	}
	
	public String ViewPuzzle() { 
		try{
			setPuzzleDescription(getPuzzlesArray().get(getCurrentRoom()-1).getPuzzleDescription());
		}catch(Exception e){
			currentRoom ++;
				//System.out.println(puzzleDescription);
		}
		return puzzleDescription;
		
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

	
	@Override
	public String toString() {
		return puzzleID + " | " + puzzleDescription + " | " + puzzleAnswer + " | " + puzzleHint + " | ";
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

	public ArrayList<Puzzles> getPuzzlesArray() {
		return puzzlesArray;
	}

	public int getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}
	/*public void printPuzzle() {
		System.out.println("puzzle");
	}
	 */
	/*public int getNumAttempts() {
		return numAttempts;
	}
	 */
	/*	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}
	 */

}