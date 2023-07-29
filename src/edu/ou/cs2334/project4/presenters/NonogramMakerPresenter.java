package edu.ou.cs2334.project4.presenters;

import java.awt.Window;
import java.io.File;

import edu.ou.cs2334.project4.interfaces.Openable;
import edu.ou.cs2334.project4.interfaces.Saveable;
import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.NonogramMakerView;
import javafx.scene.layout.Pane;

public class NonogramMakerPresenter implements Openable, Saveable {
	private NonogramMakerView view;
	private NonogramMakerModel model;
	
	private int numRows;
	private int numCols;
	
	
	
	private int cellLength;
	
	public NonogramMakerPresenter(int numRows, int numCols, int cellLength) {
		view = new NonogramMakerView(numRows, numCols, cellLength);
		model = new NonogramMakerModel(numRows, numCols);
		
		this.numRows = numRows;
		this.numCols = numCols;
		this.cellLength = cellLength;
	}
	
	private Window getWindow() {
		return view.getPane();
	}
	
	private void init() {
		
	}
	
	private void initToggleButtons() {
		
	}
	
	private void bindToggleButtons() {
		
	}
	
	private void configureMenuItems() {
		
	}
	
	public Pane getPane() {
		
	}
	
	public void open (File file) {
		
	}
	
	public void save (String filename) {
		
	}
}
