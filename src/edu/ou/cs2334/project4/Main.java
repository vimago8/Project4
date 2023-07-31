package edu.ou.cs2334.project4;

import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.CellGridView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private static final int IDX_NUM_ROWS = 0;
	private static final int IDX_NUM_COLS = 1;
	private static final int IDX_CELL_SIZE = 2;
	
	public static void main(String[] args) {
		NonogramMakerModel model = new NonogramMakerModel(2, 2);
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void start(Stage applicationStage) throws Exception {
		// TODO Auto-generated method stub
		CellGridView cellGrid = new CellGridView(4, 4, 50);
		Pane pane = cellGrid.getPane();
		Scene scene = new Scene(pane);
		
		applicationStage.setScene(scene);
		applicationStage.setTitle("CellGridView test");
		applicationStage.show();
		
	}
}
