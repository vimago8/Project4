package edu.ou.cs2334.project4.views;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CellGridView {
	private ArrayList<ToggleButton> gridButtons;
	private GridPane gridPane;
	private int numRows;
	private int numCols;
	
	public CellGridView(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridPane = new GridPane();
		gridButtons = new ArrayList<ToggleButton>();
		
		gridPane.setAlignment(Pos.CENTER);
		
		initButtons(numRows, numCols, cellLength);
		
		
		
	}
	
	public void initButtons(int numRows, int numCols, int cellLength) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		gridButtons.clear();
		gridPane.getChildren().clear();
		
		for(int i = 0; i < (numRows * numCols); ++i) {
			ToggleButton temp = new ToggleButton();
			temp.minWidth(cellLength);
			temp.maxWidth(cellLength);
			temp.minHeight(cellLength);
			temp.maxHeight(cellLength);
			gridButtons.add(temp);
		}
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	
	//REMOVE LATER
	public ArrayList<ToggleButton> getGridButtons () {
		return gridButtons;
	}
	
	public ToggleButton getToggleButton(int row, int col) {
		//row and col are indices
		++row; //non index
		++col; //non index
		//int pos = (numCols * (row + 1)) - (numCols - (col + 1)); //index of gridButtons
		int pos2 = (numCols * row) - (numCols - col);
		--pos2;
		return gridButtons.get(pos2);
	}
	
	public Pane getPane() {
		return gridPane;
	}
	
	
}
