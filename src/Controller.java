import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	//Monster monster;
	Commands command;
	Puzzles puzzle = new Puzzles();
	Monster monster = new Monster();
	Rooms room = new Rooms();
	Login login = new Login();
	Items item = new Items();
	Navigation nav = new Navigation();
	String dropdown;

	public void newGameListener(Button button) {
		button.setOnAction(e -> {
			
		});
	}

	public void loadGameListener(Button button) {

		// command = new Commands();
		button.setOnAction(e -> {
			// command.loadGame();
			System.out.println("worked");
		});
	}
	//method that takes a button, then a listener is glued to the button
	//the model's method is called within here
	//model is the Rooms Class
	
	public void showInventoryListener(Button button) {
		button.setOnAction(e -> {
			Alert popUp = new Alert(AlertType.CONFIRMATION);
			popUp.getDialogPane().setContentText(Items.getInventory().toString());
			popUp.showAndWait();
		});
	}

	public void examineRoomListener(Button temp) {
		//System.out.println("examine room");
		temp.setId("r"+room.getRoomID());

		temp.setOnAction(e -> {
			room.addObserver(LostTreasureMain.gui);
			room.ExamineRoom();
			for(Rooms roomTemp : room.getRoomsArray()){
				if(roomTemp.getRoomName().equals(dropdown)){
					roomTemp.setExamined(true);
					room.enableButtons(LostTreasureMain.gui.searchRoom);	
				}
			}
				

		});
	}
	
	public void pickupItemListener(Button temp) {
		temp.setId(item.getItemID() + "Added to Inventory");
		temp.setOnAction(e -> {
			item.addObserver(LostTreasureMain.gui);
			item.viewItems(room.getCurrentRoom());
			Items.getInventory().add(item);
		
		});
	}
	
	public void viewPuzzleListener(Button temp){
		temp.setId(puzzle.getPuzzleDescription());
		temp.setOnAction(e -> {
			puzzle.addObserver(LostTreasureMain.gui);
			puzzle.ViewPuzzle(room.getCurrentRoom());

		});
	}

	public void viewMonsterListener(Button temp){
		temp.setId(monster.getMonsterDescription());
		temp.setOnAction(e -> {
			monster.addObserver(LostTreasureMain.gui);
			monster.ViewMonster(room.getCurrentRoom());
		});
	}
		public void viewHintListener(Button temp){
			temp.setId(puzzle.getPuzzleHint());
			temp.setOnAction(e -> {
				puzzle.addObserver(LostTreasureMain.gui);
				puzzle.ViewHint(room.getCurrentRoom());
			});
		}
		public void viewAnswerListener(Button temp){
			temp.setId(puzzle.getPuzzleAnswer());
			temp.setOnAction(e -> {
				puzzle.addObserver(LostTreasureMain.gui);
				puzzle.ViewAnswer(room.getCurrentRoom());
			});
		}

		public void searchRoomListener(Button temp){
			temp.setId(item.getItemDescription());
			temp.setOnAction(e -> {
				item.addObserver(LostTreasureMain.gui);
				item.viewItems(room.getCurrentRoom());
				for(Rooms roomTemp : room.getRoomsArray()){
					if(roomTemp.getRoomName().equals(dropdown)){
						roomTemp.setSearched(true);
						System.out.println(roomTemp.isSearched());
						room.enableButtons(LostTreasureMain.gui.pickupItem);	
					}
				}
			});
			
		}
		public void fleeMonsterListener(Button flee) {
			flee.setOnAction(e->{
				monster.fleeMonster();
			});
		}
		public void attactMonsterListener(Button attack) {
			attack.setOnAction(e->{
				System.out.println("you have attacked the monster");
				LostTreasureMain.gui.mapPane().setVisible(true);
			});
		}
		
		
	
//refreshes the map pane
//re populates the drop-down with the available rooms
	public void refreshMap(Button temp){
	
		temp.setOnAction(e->{
			nav.addObserver(LostTreasureMain.gui);
			 dropdown = GUI.gui.getRoomsDropDown().getValue();
				
			for(Rooms roomTemp : room.getRoomsArray()){
				if(roomTemp.getRoomName().equals(dropdown)){
					if(roomTemp.isLocked() == true){
						if(Items.getInventory().contains(item)) {
							roomTemp.setLocked(item.unlockDoor());
							room.doorUnlockedPopUp(roomTemp.getRoomName());
							System.out.println("is the room locked? " + roomTemp.isLocked());
							break;
						}
						room.loadPopUp(roomTemp.getRoomName());
					
						break;
					}
					nav.setCurrentRoom(roomTemp.getNumRoomID()); 
					nav.refreshMap(roomTemp.getNumRoomID());
					room.setCurrentRoom(roomTemp.getNumRoomID());
					GUI.gui.getRoomsDropDown().getItems().clear();//clears the previous drop-down
					room.availableRoom(room.getCurrentRoom());//calls the available room method wit the room number that user went to
					//GUI.gui.getRoomsDropDown().getItems().addAll(roomTemp.getRoomIDArray());
					//System.out.println("is the room locked? " + roomTemp.isLocked());
					System.out.println("is the room examined? " + roomTemp.isExamined());
					room.enableButtons(LostTreasureMain.gui.examine);
					
					if(roomTemp.isExamined()==false) {
						room.disableButton(LostTreasureMain.gui.searchRoom);
					}
					if(roomTemp.isSearched()==false) {
						room.disableButton(LostTreasureMain.gui.pickupItem);
					}
					
				}
				
				//
			
			}


			room.getCurrentRoom();
		});
	}

}
