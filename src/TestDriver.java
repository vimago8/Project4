import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.layout.Pane;
import edu.ou.cs2334.project4.models.NonogramMakerModel;
import edu.ou.cs2334.project4.views.CellGridView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class TestDriver extends Application {
	public static void main (String[] args) throws FileNotFoundException {
//		NonogramMakerModel model = new NonogramMakerModel(5, 5);
//		System.out.println(Arrays.toString(model.getGrid()));
		
		//File spaceInvader = new File("space-invader.txt");
		//model = new NonogramMakerModel(spaceInvader);
		//System.out.println(Arrays.toString(model.getGrid()));
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		int[] array1 = {1, 2, 3, 
						4, 5, 6,
						7, 8, 9};
		
		int numRows = 3; 
		int numCols = 3;
		int rowIdx = 0; //pos 1
		int colIdx = 2; //pos 1
		
		int targetIndex = (numRows * 1) - (numCols - 1);
		targetIndex = (numCols * (rowIdx + 1)) - (numCols - (colIdx + 1));
		targetIndex -= 1; //actual index
		
		System.out.println(array1[targetIndex]); //should be 2
		
		CellGridView testCell = new CellGridView(4, 4, 1);
		System.out.println("getNumRows: " + testCell.getNumRows()); //3
		System.out.println("getNumCols: " + testCell.getNumCols()); //3
		System.out.println("gridButton size: " + testCell.getGridButtons().size());
		
		ToggleButton button = testCell.getToggleButton(0, 0); //check if exists at indices
		System.out.println(button);
		button = testCell.getToggleButton(1, 1);
		System.out.println(button);
		
		try {
			button = testCell.getToggleButton(2, 2);
			System.out.println(button);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			button = testCell.getToggleButton(3, 3);
			System.out.println(button);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void start(Stage applicationStage) throws Exception {
		// TODO Auto-generated method stub
		CellGridView cellGrid = new CellGridView(3, 3, 1);
		Pane pane = cellGrid.getPane();
		Scene scene = new Scene(pane);
		
		applicationStage.setScene(scene);
		applicationStage.setTitle("CellGridView test");
		applicationStage.show();
		
	}
}
