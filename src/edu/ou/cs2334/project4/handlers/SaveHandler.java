package edu.ou.cs2334.project4.handlers;

import javafx.stage.Window;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;

import edu.ou.cs2334.project4.interfaces.Saveable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
/**
 * Handles saving operations. 
 * @author Grace Lee
 * @version 1.0
 */
public class SaveHandler extends AbstractBaseHandler implements EventHandler<ActionEvent> {
	private Saveable saver;
	
	/**
	 * Handles saving a file given a window. Enables user to save a file from the filesystem.
	 * @param window
	 * @param fileChooser
	 * @param saver
	 */
	public SaveHandler(Window window, FileChooser fileChooser, Saveable saver) {
		super(window, fileChooser);
		this.saver = saver;
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		File file = fileChooser.showSaveDialog(window);
		String filename = file.getName();
		if(file != null) {
			try {
				saver.save(filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
