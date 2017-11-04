import java.util.Observable;

public class Navigation extends Observable{
	private int counter;
	public void showMap() {
System.out.println("show map method");
	}

	public void hideMap() {

	}

	public void refreshMap(String temp) {
		counter++;
		setChanged();
		notifyObservers(counter);
		System.out.println("refresh map");
	}
}
