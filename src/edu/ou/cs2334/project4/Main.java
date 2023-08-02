package edu.ou.cs2334.project4;

import java.util.List;

import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.presenters.NonogramMakerPresenter;
import edu.ou.cs2334.project4.views.CellGridView;
import edu.ou.cs2334.project4.views.NonogramMakerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * Where the stage is set and everything runs
 * @author Grace Lee
 * @version 1.0
 */
public class Main extends Application {
	private static final int IDX_NUM_ROWS = 0;
	private static final int IDX_NUM_COLS = 1;
	private static final int IDX_CELL_SIZE = 2;
	
	public static void main(String[] args) {
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override	
	public void start(Stage applicationStage) throws Exception {
		// TODO Auto-generated method stub
		
		List<String> string = getParameters().getUnnamed();
		int numRows = Integer.parseInt(string.get(0));
		int numCols = Integer.parseInt(string.get(1));
		int cellLength = Integer.parseInt(string.get(2));
		
		
		NonogramMakerPresenter nonoPres = new NonogramMakerPresenter(numRows, numCols, cellLength);
		Scene nonoScene = new Scene(nonoPres.getPane());
		
		nonoScene.getStylesheets().add("style.css");
		
		applicationStage.setScene(nonoScene);
		applicationStage.setTitle("Nonogram Maker");
		applicationStage.setResizable(false);
		applicationStage.show();
				

		
	}
}
