package edu.ou.cs2334.project4.handlers;

import java.awt.Window;
import java.awt.event.ActionEvent;

import edu.ou.cs2334.project4.interfaces.Openable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class OpenHandler extends AbstractBaseHandler implements EventHandler {
	private Openable opener;
	
	public OpenHandler(Window window, FileChooser fileChooser, Openable opener) {
		super(window, fileChooser);
	}
	
	public void handle(ActionEvent event) {
		
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
