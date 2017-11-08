//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Observable;
//import java.util.Random;
//import java.util.Scanner;

public class Puzzles extends Observable {

	private String puzzleID;
	private String puzzleDescription;
	private String puzzleAnswer;
	private String puzzleHint;
	private int numAttempts =0;


	public Puzzles(String puzzleID, String puzzleDescription, String puzzleAnswer, String puzzleHint, int numAttempts)
	{
		this.puzzleID = puzzleID;
		this.puzzleDescription = puzzleDescription;
		this.puzzleAnswer = puzzleAnswer;
		this.puzzleHint = puzzleHint;
		this.numAttempts = numAttempts;

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


	public int getNumAttempts() {
		return numAttempts;
	}


	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}


	public void AnswerPuzzleCorrectly()
	{
			// add method here
	}

	public void AnswerPuzzleIncorrectly()
	{
	}

}