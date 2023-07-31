package edu.ou.cs2334.project4.handlers;

import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.models.NonogramMakerModel;
/**
 * Implements an EventHandler for ToggleButtons in CellGridView
 * @author Grace Lee
 * @version 1.0
 *
 */
public class ToggleButtonEventHandler {
	private NonogramMakerModel model;
	private int rowIdx;
	private int colIdx;
	
	/**
	 * Gets the state of the toggleButton(true or false) and sets the corresponding cell in the model
	 * with that state.
	 * @param model
	 * @param rowIdx
	 * @param colIdx
	 */
	public ToggleButtonEventHandler(NonogramMakerModel model, int rowIdx, int colIdx) {
		this.model = model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
		
		
		
	}
	
	public void handle(ActionEvent event) {
		
	}
}
