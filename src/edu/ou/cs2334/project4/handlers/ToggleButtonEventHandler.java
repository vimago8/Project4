package edu.ou.cs2334.project4.handlers;

import javafx.event.ActionEvent;

import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.presenters.NonogramMakerPresenter;
/**
 * Implements an EventHandler for ToggleButtons in CellGridView
 * @author Grace Lee
 * @version 1.0
 *
 */
public class ToggleButtonEventHandler {
	private NonogramMakerPresenter presenter;
	private int rowIdx;
	private int colIdx;
	
	/**
	 * Gets the state of the toggleButton(true or false) and sets the corresponding cell in the model
	 * with that state.
	 * @param model
	 * @param rowIdx
	 * @param colIdx
	 */
	public ToggleButtonEventHandler(NonogramMakerPresenter presenter, int rowIdx, int colIdx) {
		this.presenter = presenter;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
		
		
		ToggleButton button = presenter.
		
		
	}
	
	public void handle(ActionEvent event) {
		if(event.getClass)
	}
}
