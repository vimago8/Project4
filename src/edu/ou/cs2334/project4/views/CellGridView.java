package edu.ou.cs2334.project4.views;

import java.util.ArrayList;



import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * 
 * This class creates a GridPane of ToggleButtons to be connected with NonogramMakerModel in NonogramMakerPresenter.
 * Field includes an ArrayList of ToggleButtons that are added to the GridPane
 * @author Grace Lee
 * @version 1.0
 *
 */

public class CellGridView {
	private ArrayList<ToggleButton> gridButtons;
	private GridPane gridPane;
	private int numRows;
	private int numCols;
	
	/**
	 * Constructor for a cell grid. Initializes the GridPane and ArrayList, and sets GridPane alignment
	 * @param numRows
	 * @param numCols
	 * @param cellLength
	 */
	
	public CellGridView(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridPane = new GridPane();
		gridButtons = new ArrayList<ToggleButton>();
		
		gridPane.setAlignment(Pos.CENTER);

	 
		
		initButtons(numRows, numCols, cellLength);
		
		
		//adding buttons to the gridpane
		for(int i = 0; i < this.numRows; ++i) {
			for(int k = 0; k < this.numCols; ++k) {
				gridPane.add(getToggleButton(i, k), k, i);
			}
		}
		
	}
	
	/**
	 * Initializes buttons corresponding to numRows * numCols. Adds them to the ArrayList.
	 * @param numRows
	 * @param numCols
	 * @param cellLength
	 */
	
	public void initButtons(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridButtons.clear();
		gridPane.getChildren().clear();

		
		
		for(int i = 0; i < (numRows * numCols); ++i) {
			ToggleButton temp = new ToggleButton();
			temp.minWidth(cellLength);
			
			temp.setMaxWidth(cellLength);
			temp.setPrefWidth(cellLength);
			temp.setMinHeight(cellLength);
			temp.setMaxHeight(cellLength);
			temp.setPrefHeight(cellLength);
			gridButtons.add(temp);
		}
	}
	
	/**
	 * Returns numRows
	 * @return number of rows
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * Returns numCols
	 * @return number of columns
	 */
	public int getNumCols() {
		return numCols;
	}
	
	
	//REMOVE LATER
	public ArrayList<ToggleButton> getGridButtons () {
		return gridButtons;
	}
	
	/**
	 * Returns a ToggleButton
	 * @param row
	 * @param col
	 * @return a ToggleButton at the specified indices
	 */
	public ToggleButton getToggleButton(int row, int col) {
		//row and col are indices
		++row; //non index
		++col; //non index
		int pos2 = (numCols * row) - (numCols - col);
		--pos2;
		return gridButtons.get(pos2);
	}
	
	/**
	 * Returns gridPane
	 * @return the GridPane
	 */
	public Pane getPane() {
		return gridPane;
	}
	
	
}
