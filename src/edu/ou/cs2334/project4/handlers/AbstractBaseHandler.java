package edu.ou.cs2334.project4.handlers;

import javafx.stage.Window;

import javafx.event.Event;
import javafx.stage.FileChooser;
/**
 * An interface for file selection
 * 
 * @author Grace Lee
 * @version 1.0;
 */
public abstract class AbstractBaseHandler {
	protected Window window;
	protected FileChooser fileChooser;
	
	protected AbstractBaseHandler(Window window, FileChooser fileChooser) {
		this.window = window;
		this.fileChooser = fileChooser;
	}
}
