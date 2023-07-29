package edu.ou.cs2334.project4.handlers;

import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.models.NonogramMakerModel;

public class ToggleButtonEventHandler {
	private NonogramMakerModel model;
	private int rowIdx;
	private int colIdx;
	
	public ToggleButtonEventHandler(NonogramMakerModel model, int rowIdx, int colIdx) {
		this.model = model;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
		
	}
	
	public void handle(ActionEvent event) {
		
	}
}
