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

/**
 * Creates the entire GUI for the project. Adds a window and the File menu at the top.
 * @author Grace Lee
 * @version 1.0
 */

public class NonogramMakerView {
	private BorderPane borderPane;
	private MenuBar menuBar;
	private CellGridView cellGridView;
	private HashMap<String, MenuItem> menuItemsMap;
	
	public final String MENU_ITEM_OPEN = "MENU_ITEM_OPEN";
	public final String MENU_ITEM_SAVE = "MENU_ITEM_SAVE";
	public final String MENU_ITEM_EXIT = "MENU_ITEM_EXIT";
	
	/**
	 * Initializes borderPane, menuBar, and cellGridView. Sets alignment for borderPane.
	 * @param numRows
	 * @param numCols
	 * @param cellLength
	 */
	public NonogramMakerView (int numRows, int numCols, int cellLength) {
		borderPane = new BorderPane();
		cellGridView = new CellGridView(numRows, numCols, cellLength);
		//initialize menu bar
		initMenuBar();
		borderPane.setCenter(cellGridView.getPane());
		//set top with menu bar
		borderPane.setTop(menuBar);
	}
	
	/**
	 * Initializes menuBar and menuItemsMap. Adds open, exit, and save components to the menuBar.
	 */
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
	
	/**
	 * Returns MenuItem
	 * @param name
	 * @return a menuItem from the menuItemsMap with given name
	 */
	public MenuItem getMenuItem(String name) {
		
		return menuItemsMap.get(name);
	}
	
	/**
	 * gets borderPane
	 * @return borderPane
	 */
	public Pane getPane() {
		return borderPane;
	}
	
	/**
	 * Initializes buttons by calling the initButtons method in cellGridView
	 * @param numRows
	 * @param numCols
	 * @param cellLength
	 */
	public void initButtons(int numRows, int numCols, int cellLength) {
		cellGridView.initButtons(numRows, numCols, cellLength);
	}
	
	/**
	 * Gets cellGridView.getToggleButton
	 * @param row
	 * @param col
	 * @return getToggleButton method in cellGridView
	 */
	public ToggleButton getToggleButton(int row, int col) {
		return cellGridView.getToggleButton(row, col);
	}
	
	/**
	 * Returns cellGridView.getNumRows
	 * @return numRows in the cellGridView
	 */
	public int getNumRows() {
		return cellGridView.getNumRows();
	}
	
	/**
	 * Returns cellGridView.getNumCols
	 * @return numCols in the cellGridView
	 */
	public int getNumCols() {
		return cellGridView.getNumCols();
	}
	
}
