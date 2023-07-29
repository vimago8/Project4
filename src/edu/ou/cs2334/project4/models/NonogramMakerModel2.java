package edu.ou.cs2334.project4.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		NonogramMakerModel2 model2 = new NonogramMakerModel2("puzzles/ou-logo.txt");
		System.out.println(model.getNumRows());
		System.out.println(model.getNumCols());
		
//		System.out.println(model2.getNumRows());
//		System.out.println(model2.getNumCols());
		
		System.out.println(Arrays.toString(model.getGrid()));
		//System.out.println(Arrays.toString(model2.getGrid()));
		
		System.out.println(model.getCell(17, 11));
		
		model.setCell(17, 11, false);
		System.out.println(model.getCell(17, 11));
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
//	public static List<Integer> project(boolean[] cells) {
//		
//	}
//	
//	public List<Integer> projectRow (int rowIdx) {
//		
//	}
//	
//	public List<Integer> projectCol (int colIdx) {
//		
//	}
//	
//	public void saveToFile(String filename) {
//		
//	}
//	
//	public String toString() {
//		
//	}
}
