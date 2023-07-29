package edu.ou.cs2334.project4.handlers;

import java.awt.Window;
import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.interfaces.Saveable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class SaveHandler extends AbstractBaseHandler implements EventHandler {
	private Saveable saver;
	
	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window, fileChooser);
		
	}
	
	public void handle(ActionEvent event) {
		
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}
}
