package edu.ou.cs2334.project4.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.ou.cs2334.project4.models.NonogramMakerModel;

/**
 * Implements an EventHandler for ToggleButtons in CellGridView
 * @author Grace Lee
 * @version 1.0
 *
 */
public class ToggleButtonEventHandler implements EventHandler<ActionEvent> {
	private NonogramMakerModel model;
	private int rowIdx;
	private int colIdx;
	
	/**
	 * Gets the state of the toggleButton(true or false) and sets the corresponding cell in the model
	 * with that state.
	 * @param presenter a NonogramMakerPresenter object
	 * @param rowIdx row index
	 * @param colIdx column index
	 */
	public ToggleButtonEventHandler(NonogramMakerModel model, int rowIdx, int colIdx) {
		this.model= model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;

	}
	
	

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.setCell(rowIdx, colIdx, !(model.getCell(rowIdx, colIdx)));
		
		
	}
}
