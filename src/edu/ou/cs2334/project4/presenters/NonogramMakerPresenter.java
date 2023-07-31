package edu.ou.cs2334.project4.presenters;

import javafx.stage.Window;
import java.io.File;
import edu.ou.cs2334.project4.interfaces.Openable;
import edu.ou.cs2334.project4.interfaces.Saveable;
import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.NonogramMakerView;
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
	 * @param numRows
	 * @param numCols
	 * @param cellLength
	 */
	public NonogramMakerPresenter(int numRows, int numCols, int cellLength) {
		view = new NonogramMakerView(numRows, numCols, cellLength);
		model = new NonogramMakerModel(numRows, numCols);
		
		this.numRows = numRows;
		this.numCols = numCols;
		this.cellLength = cellLength;
	}
	/**
	 * Returns window of view
	 * @return the Window of the Scene of the Pane of NonogramMakerView
	 */
	private Window getWindow() {
		return view.getPane().getScene().getWindow();
	}
	
	/**
	 * Initializes the togglebuttons and connects them with the model.
	 */
	private void init() {
		
	}
	
	/**
	 * Call view.initButtons() with the field variable dimensions. If the window is not null, 
	 * call .sizeToScene() so the window so the window is not too big/small
	 */
	private void initToggleButtons() {
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
			}
		}
		
	}
	
	/**
	 * Sets event handlers for the open and save buttons.
	 */
	private void configureMenuItems() {
		
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
	 */
	public void open (File file) {
		
	}
	
	/**
	 * 
	 */
	public void save (String filename) {
		
	}
}
