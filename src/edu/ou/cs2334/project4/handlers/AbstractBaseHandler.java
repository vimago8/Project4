package edu.ou.cs2334.project4.handlers;

import java.awt.Window;

import javafx.stage.FileChooser;

public abstract class AbstractBaseHandler {
	protected Window window;
	protected FileChooser fileChooser;
	
	protected AbstractBaseHandler(Window window, FileChooser fileChooser) {
		
	}
}
