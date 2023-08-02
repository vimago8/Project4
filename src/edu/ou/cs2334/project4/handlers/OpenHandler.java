package edu.ou.cs2334.project4.handlers;

import javafx.stage.Window;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.ou.cs2334.project4.interfaces.Openable;
import edu.ou.cs2334.project4.presenters.NonogramMakerPresenter;
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

public class OpenHandler extends AbstractBaseHandler implements EventHandler<ActionEvent>{
	private Openable opener;
	
	/**
	 * Handles opening a file given a window. Enables user to open a file from the filesystem.
	 * @param window window from which the file is opened
	 * @param fileChooser object that gives access to the file system
	 * @param opener an object that implements Openable
	 */
	public OpenHandler(Window window, FileChooser fileChooser, Openable opener) {
		super(window, fileChooser);
		this.opener = opener;
		
		
		
		
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		File file = fileChooser.showOpenDialog(window);
		if(file != null) {
			try {
				opener.open(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	

	

	
	
}
