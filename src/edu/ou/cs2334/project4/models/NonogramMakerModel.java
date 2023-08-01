package edu.ou.cs2334.project4.models;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * This class is the model for the NonogramMaker. It handles the reading and creation of puzzle files
 * @author Grace Lee
 * @version 1.0
 * 
 *
 */

public class NonogramMakerModel {
/**
 * @value EMPTY_CELL_CHAR represents an empty nonogram slot, represented by 0 in the files
 * @value FILLED_CELL_CHAR represents a filled nonogram slot, represented by 1 in the files
 * @value The grid array stores the nonogram layout in a 1d format, with row major order (left to right)
 */
	private static final char EMPTY_CELL_CHAR = '0';
	private static final char FILLED_CELL_CHAR = '1';
	
	private int numRows;
	private int numCols;
	
	private boolean[] grid;
	
	public NonogramMakerModel(int numRows, int numCols) {
		if(numRows <= 0 || numCols <=0) {
			throw new IllegalArgumentException();
		}
		this.numRows = numRows;
		this.numCols = numCols;
		
		grid = new boolean[numRows * numCols];
	}
	
/**
 * Reads a file, stores relevant information to fields
 * @param file a file containing the puzzle
 * @throws FileNotFoundException
 * @throws IOException
 */
	public NonogramMakerModel(File file) throws FileNotFoundException, IOException {
		Scanner scnr = new Scanner(file);
		
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
	/**
	 * Creates a file using string parameter, then reads in relevant information
	 * @param filename the name of the puzzle file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public NonogramMakerModel(String filename) throws FileNotFoundException , IOException{
		this(new File(filename));
	}
	
	/**
	 * Returns the grid array
	 * @return grid
	 */
	public boolean[] getGrid () {
		return grid;
	}
	/**
	 * Returns cell corresponding to the row and column index provided
	 * @param rowIdx row index
	 * @param colIdx row index
	 * @return
	 */
	public boolean getCell(int rowIdx, int colIdx) {
		++rowIdx;
		++colIdx;
		int pos = (numCols * rowIdx) - (numCols - colIdx);
		--pos;
		return grid[pos];
	}
	/**
	 * Sets the cell corresponding to the given row and column value with the given state
	 * @param rowIdx row index
	 * @param colIdx row index
	 * @param state state of cell to be set
	 */
	public void setCell(int rowIdx, int colIdx, boolean state) {
		++rowIdx;
		++colIdx;
		int pos = (numCols * rowIdx) - (numCols - colIdx);
		--pos;
		
		grid[pos] = state;
		
	}
	/**
	 * Returns number of rows
	 * @return numRows
	 */
	public int getNumRows() {
		return numRows;
	}
	/**
	 * Returns number of columns
	 * @return numCols
	 */
	public int getNumCols() {
		return numCols;
	}
	/**
	 * Stores nonogram numbers in a list corresponding to the boolean array given
	 * @param cells boolean array
	 * @return List of integers
	 */
	public static List<Integer> project(boolean[] cells) {
		List<Integer> projection = new ArrayList<Integer>();
		
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
	/**
	 * Given a row index, stores the nonogram numbers corresponding to that row's states in a list
	 * @param rowIdx row index
	 * @return List of integers
	 */
	public List<Integer> projectRow (int rowIdx) {
		
		boolean[] row = new boolean[numCols];
		
		for(int i = 0; i < numCols; ++i) {
			row[i] = getCell(rowIdx, i);
		}
		
		return project(row);
		
	}
	/**
	 * Given a col index, stores the nonogram numbers corresponding to that column's states in a list
	 * @param colIdx column index
	 * @return List of Integers
	 */
	public List<Integer> projectCol (int colIdx) {
		boolean[] column = new boolean[numRows];
		
		for(int i = 0; i < numRows; ++i) {
			column[i] = getCell(i, colIdx);
		}
		
		return project(column);
	}
	/**
	 * Writes a string containing a puzzle to a file. Creates a new file if it doesn't exist yet.
	 * @param filename name of file to be saved to
	 * @throws IOException
	 */
	public void saveToFile(String filename) throws IOException {
		File file = new File(filename);
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file);
		
		BufferedWriter buffWrite = new BufferedWriter(writer);
		buffWrite.write(toString());
		
		buffWrite.close();
		
	}
	/**
	 * Creates a string representation of a puzzle file using fields.
	 * 
	 */
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
				if(k == numCols - 1) {
					break;
				}
				//txtString += " ";
			}
			
			if(i == numRows - 1) {
				break;
			}
			txtString += "\n";
		}
		
		return txtString;
	}
}


