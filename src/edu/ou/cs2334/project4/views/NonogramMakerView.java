package edu.ou.cs2334.project4.views;




import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.HashMap;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class NonogramMakerView {
	private BorderPane borderPane;
	private MenuBar menuBar;
	private CellGridView cellGridView;
	private HashMap<String, MenuItem> menuItemsMap;
	
	public final String MENU_ITEM_OPEN = "MENU_ITEM_OPEN";
	public final String MENU_ITEM_SAVE = "MENU_ITEM_SAVE";
	public final String MENU_ITEM_EXIT = "MENU_ITEM_EXIT";
	
	public NonogramMakerView (int numRows, int numCols, int cellLength) {
		borderPane = new BorderPane();
		cellGridView = new CellGridView(numRows, numCols, cellLength);
		//initialize menu bar
		initMenuBar();
		borderPane.setCenter(cellGridView.getPane());
		//set top with menu bar
		borderPane.setTop(menuBar);
	}
	
	private void initMenuBar() {
		Menu fileMenu = new Menu("_File");
		MenuItem open = new MenuItem("_Open");
		MenuItem save = new MenuItem("_Save");
		MenuItem exit = new MenuItem("_Exit");
		
		fileMenu.getItems().addAll(open, save, exit);
		
		menuItemsMap = new HashMap<String, MenuItem>();
		menuItemsMap.put(MENU_ITEM_OPEN, open);
		menuItemsMap.put(MENU_ITEM_EXIT, exit);
		menuItemsMap.put(MENU_ITEM_SAVE, save);
		
		exit.setOnAction( new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		menuBar.getMenus().add(fileMenu);
	}
	
	public MenuItem getMenuItem(String name) {
		
		return menuItemsMap.get(name);
	}
	
	public Pane getPane() {
		return borderPane;
	}
	
	public void initButtons(int numRows, int numCols, int cellLength) {
		cellGridView.initButtons(numRows, numCols, cellLength);
	}
	
	public ToggleButton getToggleButton(int row, int col) {
		return new ToggleButton();
	}
	
	public int getNumRows() {
		return cellGridView.getNumRows();
	}
	
	public int getNumCols() {
		return cellGridView.getNumCols();
	}
	
}
