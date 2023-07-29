package edu.ou.cs2334.project4.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NonogramMakerModel2 {
	private static final char EMPTY_CELL_CHAR = '0';
	private static final char FILLED_CELL_CHAR = '1';
	
	private int numRows;
	private int numCols;
	
	private boolean[] grid;
	
	public NonogramMakerModel2(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		
		grid = new boolean[numRows * numCols];
	}
	
	public NonogramMakerModel2(File file) throws FileNotFoundException, IOException {
		Scanner scnr = new Scanner(file);
//		numRows = Integer.parseInt(scnr.next());
//		numCols = Integer.parseInt(scnr.next());
		
		numRows = scnr.nextInt();
		numCols = scnr.nextInt();
		
		grid = new boolean[numRows * numCols];
		
		//skips first line
		scnr.nextLine();
		
		int numSkips = numRows + numCols;
		
		for (int i = 0; i < numSkips; ++i) {
			scnr.nextLine();
		}
		
		//reads nonogram into a single large string
		String nonogramLine = "";
		while(scnr.hasNextLine()) {
			nonogramLine = nonogramLine + scnr.nextLine();
		}
		
		char[] nonoChar = nonogramLine.toCharArray();
		
		
		for (int i = 0; i < nonoChar.length; ++i) {
			if(nonoChar[i] == EMPTY_CELL_CHAR) {
				grid[i] = false;
			} else if (nonoChar[i] == FILLED_CELL_CHAR) {
				grid[i] = true;
			}
		}
		
		scnr.close();
		
	}
	
	public NonogramMakerModel2(String filename) throws FileNotFoundException , IOException{
		this(new File(filename));
	}
	
	//test method
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File filename = new File("puzzles/ou-logo.txt");
		NonogramMakerModel2 model = new NonogramMakerModel2(filename);
//		NonogramMakerModel2 model2 = new NonogramMakerModel2("puzzles/ou-logo.txt");
//		System.out.println(model.getNumRows());
//		System.out.println(model.getNumCols());
//		
////		System.out.println(model2.getNumRows());
////		System.out.println(model2.getNumCols());
//		
//		System.out.println(Arrays.toString(model.getGrid()));
//		//System.out.println(Arrays.toString(model2.getGrid()));
//		
//		System.out.println(model.getCell(17, 11));
//		
//		boolean[] cellz = model.getGrid();
//		
//		//System.out.println("project: " + NonogramMakerModel2.project(cellz));
//		
//		
//		
//		model.setCell(17, 11, false);
//		System.out.println(model.getCell(17, 11));
//		
//		//ou third line
//		boolean[] testArray = {true,true,true,false,false,false,false,true,true,true,false,false,false,false};
//		System.out.println(NonogramMakerModel2.project(testArray));
//		
//		//ou 7th line
//		boolean [] testArray2 = {true,true,false,false,true,true,false,false,true,true,false,false,true,true};
//		System.out.println(NonogramMakerModel2.project(testArray2));
//		
//		//ou rows
////		System.out.println(model.projectRow(0));
////		System.out.println(model.projectRow(1));
////		System.out.println(model.projectRow(2));
//		
//		for(int i = 0; i < model.numRows; ++i) {
//			System.out.println("ou line " + i);
//			System.out.println(model.projectRow(i));
//		}
//		
//		System.out.println("Proj row: " + model.projectRow(17));
//		
//		NonogramMakerModel2 invModel = new NonogramMakerModel2("puzzles/space-invader.txt");
//		boolean[] invGrid = invModel.getGrid();
//		//invader rows
//		
////		System.out.println(invModel.projectRow(0));
////		System.out.println(invModel.projectRow(1));
////		System.out.println(invModel.projectRow(2));
////		System.out.println(invModel.projectRow(3));
////		System.out.println(invModel.projectRow(4));
//		
//		
////		for(int i = 0; i < invModel.numCols; ++i) {
////			System.out.println(invModel.projectRow(i));
////		}
////		
////		
////		
//		for(int i = 0; i < invModel.numCols; ++i) {
//			System.out.println(invModel.projectCol(i));
//		}
//		
//		for(int i = 0; i < model.numCols; ++i) {
//			System.out.println(model.projectCol(i));
//		}
//		
//		for(int i = 0; i < invModel.numRows; ++i) {
//			System.out.println(invModel.projectRow(i));
//		}
//		
//		for(int i = 0; i < model.numRows; ++i) {
//			System.out.println(model.projectRow(i));
//		}
////		for(int i = 0; i < model.numCols; ++i) {
////			System.out.println(model.projectCol(i));
////		}
//		System.out.println(invModel.toString());
		System.out.println(model.toString());
		
	}
	
	public boolean[] getGrid () {
		return grid;
	}
//	
	public boolean getCell(int rowIdx, int colIdx) {
		++rowIdx;
		++colIdx;
		int pos = (numCols * rowIdx) - (numCols - colIdx);
		--pos;
		return grid[pos];
	}
//	
	public void setCell(int rowIdx, int colIdx, boolean state) {
		++rowIdx;
		++colIdx;
		int pos = (numCols * rowIdx) - (numCols - colIdx);
		--pos;
		
		grid[pos] = state;
		
	}
//	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumCols() {
		return numCols;
	}
//	
	public static List<Integer> project(boolean[] cells) {
		List<Integer> projection = new ArrayList<Integer>();
		boolean bool= false;
		int trueCount = 0;
		
		for (int i = 0; i < cells.length - 1; ++i) {
			if(cells[i] == true) {
				++trueCount;
				if(cells[i] != cells[i+1]) {
					projection.add(trueCount);
					trueCount = 0;
				}
			} 
		}
		boolean lastCell = cells[cells.length-1];
		
		if(lastCell == true) {
			++trueCount;
			projection.add(trueCount);
		}
		
		if(projection.isEmpty()) {
			projection.add(0);
		}
		
		return projection;
	}
//	
	public List<Integer> projectRow (int rowIdx) {
		//List<Integer> projectionOfRow = new ArrayList<Integer>();
		//skip values until row
//		int gridRow = (numCols); 
//		gridRow = gridRow * rowIdx; //this is the index of row in grid 
//		
//		
//		//numcols - 1 is column index
//		boolean[] rowToProj = Arrays.copyOfRange(grid, gridRow, gridRow + numCols);
//		System.out.println(Arrays.toString(rowToProj)); //REMOVE later
//		return project(rowToProj);
		
		boolean[] row = new boolean[numCols];
		
		for(int i = 0; i < numCols; ++i) {
			row[i] = getCell(rowIdx, i);
		}
		
		return project(row);
		
	}
//	
	public List<Integer> projectCol (int colIdx) {
		boolean[] column = new boolean[numRows];
//		int gridRow = numCols;
		
//		for(int i = 0; i < numRows; ++i) {
//			gridRow = numCols * i;
//			boolean[] row = Arrays.copyOfRange(grid, gridRow, gridRow + numCols);
//			column[i] = row[colIdx]; 
//		}
		
		for(int i = 0; i < numRows; ++i) {
			column[i] = getCell(i, colIdx);
		}
		
		return project(column);
	}
//	
	public void saveToFile(String filename) {
		
	}
//	
	public String toString() {
		
		
		String txtString = "";
		txtString += numRows + " " + numCols + "\n";
		
		for(int i = 0; i < numRows; ++i) {
			for(int k = 0; k < projectRow(i).size();++k) {
				
				if(k == projectRow(i).size() - 1) {
					txtString += projectRow(i).get(k);
				} else {
					txtString += projectRow(i).get(k) + " ";
				}
			}
			
			if(i == numRows - 1) {
				break;
			}
			
			txtString += "\n";
		}
		
		txtString+= "\n";
		
		for(int i = 0; i < numCols; ++i) {
			for(int k = 0; k < projectCol(i).size(); ++k) {
				if(k == projectCol(i).size() - 1) {
					txtString += projectCol(i).get(k);
				} else {
					txtString += projectCol(i).get(k) + " ";
				}
			}
			
			if(i == numCols - 1) {
				break;
			}
			txtString += "\n";
		}
		
		txtString+= "\n";
		
		for(int i = 0; i < numRows; ++i) {
			for(int k = 0; k < numCols; ++k) {
				if(getCell(i, k) == false) {
					txtString += 0;
				} else {
					txtString += 1;
				}
				txtString += " ";
			}
			txtString += "\n";
		}
		
		return txtString;
	}
}
