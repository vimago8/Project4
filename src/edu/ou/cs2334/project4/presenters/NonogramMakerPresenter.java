package edu.ou.cs2334.project4.presenters;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import edu.ou.cs2334.project4.handlers.OpenHandler;
import edu.ou.cs2334.project4.handlers.SaveHandler;
import edu.ou.cs2334.project4.handlers.ToggleButtonEventHandler;
import edu.ou.cs2334.project4.interfaces.Openable;
import edu.ou.cs2334.project4.interfaces.Saveable;
import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.NonogramMakerView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;

import javafx.scene.layout.Pane;

/**
 * This class connects NonogramMakerModel and NonogramMaker view and presents them. This will be called
 * in Main.
 * @author Grace Lee
 * @version 1.0
 *
 */

public class NonogramMakerPresenter implements Openable, Saveable {
	private NonogramMakerView view;
	private NonogramMakerModel model;
	
	private int numRows;
	private int numCols;
	private int cellLength;
	
	
	/**
	 * Constructs a view and a model, and reads in their dimensions
	 * @param numRows row number
	 * @param numCols column number
	 * @param cellLength length of each cell
	 */
	public NonogramMakerPresenter(int numRows, int numCols, int cellLength) {
		view = new NonogramMakerView(numRows, numCols, cellLength);
		model = new NonogramMakerModel(numRows, numCols);
		
		this.numRows = numRows;
		this.numCols = numCols;
		this.cellLength = cellLength;
		
		init();
	}
	/**
	 * Returns window of view
	 * @return the Window of the Scene of the Pane of NonogramMakerView
	 */
	private Window getWindow() {
		try {
			return view.getPane().getScene().getWindow();
			
		} catch (NullPointerException e) {
			
			return null;
		}
		
		
 }
	
	/**
	 * Initializes the togglebuttons and connects them with the model.
	 */
	private void init() {
		initToggleButtons();
		bindToggleButtons();
		configureMenuItems();
	}
	
	/**
	 * Call view.initButtons() with the field variable dimensions. If the window is not null, 
	 * call .sizeToScene() so the window so the window is not too big/small
	 */
	private void initToggleButtons() {
		view.initButtons(numRows, numCols, cellLength);
		if(getWindow() != null) {
			getWindow().sizeToScene();
		}
	}
	
	/**
	 * Checks that each togglebutton's state matches the model's cell state, and adds an event
	 * handler for each button.
	 */
	private void bindToggleButtons() {
		for(int i = 0; i < (view.getNumRows()); ++i) {
			for(int k = 0; k < view.getNumCols(); ++k) {
				boolean modelCellState = model.getCell(i, k);
				ToggleButton togBut = view.getToggleButton(i, k);
				if(modelCellState) {
					togBut.setSelected(true);
				} else {
					togBut.setSelected(false);
				}
				
				togBut.addEventHandler(ActionEvent.ACTION, new ToggleButtonEventHandler(model, i, k));
			}
		}
		
		
		
	}
	
	/**
	 * Sets event handlers for the open and save buttons.
	 */
	private void configureMenuItems() {
		MenuItem open = view.getMenuItem("MENU_ITEM_OPEN");
		MenuItem save = view.getMenuItem("MENU_ITEM_SAVE");
		Openable var = this;
		Saveable var2 = this;
		
		open.setOnAction( new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Open");
				filechooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
				filechooser.setInitialDirectory(new File("."));
				view.getMenuItem(NonogramMakerView.MENU_ITEM_OPEN).setOnAction(new OpenHandler(getWindow(), filechooser, var));
			}
		});
		
		save.setOnAction( new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				FileChooser filechooser = new FileChooser();
				filechooser.setTitle("Save");
				filechooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
				filechooser.setInitialDirectory(new File("."));
				view.getMenuItem(NonogramMakerView.MENU_ITEM_SAVE).setOnAction(new SaveHandler(getWindow(), filechooser, var2));
			}
		});
		
	}
	
	/**
	 * Returns the pane of the view.
	 * @return view Pane
	 */
	public Pane getPane() {
		return view.getPane();
	}
	
	/**
	 * Calls the NonogramMakerModel constructor with the file parameter, and initializes togglebuttons
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void open (File file) throws FileNotFoundException, IOException {
		model = new NonogramMakerModel(file);
		numRows = model.getNumRows();
		numCols = model.getNumCols();
		
	
		init();
	}
	
	/**
	 * Calls model.saveToFile with the given filename. 
	 * @param filename name of file
	 * @throws IOException 
	 */
	public void save (String filename) throws IOException {
		model.saveToFile(filename);
	}
}
