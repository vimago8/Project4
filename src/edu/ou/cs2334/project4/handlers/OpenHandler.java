package edu.ou.cs2334.project4.handlers;

import java.awt.Window;

import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.interfaces.Openable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.stage.FileChooser;

/**
 * Used for classes that need to open or save a file. Handles operations for opening a file (when the open
 * button is pressed)
 * 
 * @author Grace Lee
 * @version 1.0
 * 
 */

public class OpenHandler extends AbstractBaseHandler implements EventHandler<Event>{
	private Openable opener;
	
	/**
	 * Handles opening a file given a window. Enables user to open a file from the filesystem.
	 * @param window
	 * @param fileChooser
	 * @param opener
	 */
	public OpenHandler(Window window, FileChooser fileChooser, Openable opener) {
		super(window, fileChooser);
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
