package edu.ou.cs2334.project4.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NonogramMakerModel {
	 private static final char EMPTY_CELL_CHAR = '0';
	 private static final char FILLED_CELL_CHAR = '1';
	 
	 private int numRows;
	 private int numCols;
	 
	 private boolean[] grid;
	 
	 public NonogramMakerModel (int numRows, int numCols) {
		 this.numRows = numRows;
		 this.numCols = numCols;
		 grid = new boolean[numRows * numCols];
	 }
	 
	 public NonogramMakerModel (File file) throws IOException {
		 
		 BufferedReader br = new BufferedReader(new FileReader("space-invader.txt"));
		 int a =0;
		 int stop = numRows+numCols+1;
		 while (a<stop) {
			 br.readLine();
		 }
		 
		 
		 String test_line;
		 String fullGrid="";
		 while( (test_line = br.readLine()) != null ) {
			 fullGrid+=test_line;
		 }
		
		 char[] fullGridChar=fullGrid.toCharArray();
		 for(int i=0;i<fullGridChar.length;i++) {
			 if(fullGridChar[i]=='1') {
				 grid[i] = true;
			 }
			 else{
				 grid[i] = false;
			 }
		 }
		 
		 
		 
		
 /*
		  
		 Scanner scnr = new Scanner(file);
		 this.numRows = scnr.nextInt();
		 this.numCols = scnr.nextInt();
		 
		 //skips all lines until full nonogram picture
		 //skips the first line, then skips (numRows + numCols) lines after
		 for (int i = 0; i < (numRows + numCols + 1); ++i) {
			 scnr.nextLine();
			 System.out.println("lines skipped: " + i);
		 }
		 
		 grid = new boolean[numRows * numCols];
		 String line;
		 char[] lineArray;
		 
 */
		 
//		 for (int i = 0; i < grid.length; ++i) {
//			  temp = scnr.next();
//			 if(temp == EMPTY_CELL_CHAR) {
//				 grid[i] = false;
//			 } else if (temp == FILLED_CELL_CHAR) {
//				 grid[i] = true;
//			 }
//		 }
		 
//		 for(int i = 0; i < numRows; ++i) {
//			 line = scnr.nextLine();
//			 lineArray = line.toCharArray();
//			 
//			 for(int j = 0; j < lineArray.length; ++j) {
//				 if(lineArray[j] == EMPTY_CELL_CHAR) {
//					 
//				 }
//			 }
//		 }
		 
		 
		 
	}
	 
	 public NonogramMakerModel (String filename) throws IOException {
		 File insert = new File(filename);
		 new NonogramMakerModel(insert);
	 }
	 
	 public boolean[] getGrid() {
		 return grid;
	 }
	 
	 public boolean getCell(int rowIdx, int colIdx) {
		  
		 
		 return grid[(rowIdx*numCols)+colIdx];
		 
	 
	 }
	 
	 public void setCell(int rowIdx, int colIdx, boolean state) {
		 
	 }
	 
	 public int getNumRows () {
		 return numRows;
	 }
	 
	 public int getNumCols() {
		 return numCols;
	 }
	 
	 public static List<Integer> project (boolean[] cells) {
		 return new LinkedList<Integer>();
	 }
	 
	 public List<Integer> projectRow (int rowIdx) {
		 return new LinkedList<Integer>();
	 }
	 
	 public List<Integer> projectCol (int colIdx) {
		 return new LinkedList<Integer>();
	 }
	 
	 public void saveToFile (String filename) {
		 
	 }
	 
	 public String toString () {
		 return "";
	 }
}
}
