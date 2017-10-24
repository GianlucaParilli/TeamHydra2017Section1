import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Commands implements Observable {
	private String username;
	
	public void writer(ArrayList<String> array) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("usernameSave.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		for (String temp : array) {
			writer.println(temp);
		}
		writer.close();
	}

	public void newGame() {

		System.out.println("gggg");

	}

	public void loadGame() {

		Commands com = new Commands();
		com.addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				System.out.println("aaaaaa");
			}
		});
	}

	public void exitGame() {

	}

	@Override
	public void addListener(InvalidationListener listener) {
		// System.out.println("");
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub

	}



	
}
