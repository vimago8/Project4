package edu.ou.cs2334.project4.handlers;

import java.awt.Window;
import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.interfaces.Saveable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
/**
 * Handles saving operations. 
 * @author Grace Lee
 * @version 1.0
 */
public class SaveHandler extends AbstractBaseHandler implements EventHandler<Event> {
	private Saveable saver;
	
	/**
	 * Handles saving a file given a window. Enables user to save a file from the filesystem.
	 * @param window
	 * @param fileChooser
	 * @param saver
	 */
	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window, fileChooser);
		
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}
}
