package net.ahjota.praxis.sudoku;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Write a program to solve sudoku puzzles; your program may assume the puzzle
 * is well-formed. What is the solution of the above puzzle?
 * 
 * @see <a href="http://programmingpraxis.com/2009/02/19/sudoku/"
 *      >http://programmingpraxis.com/2009/02/19/sudoku/</a>
 * 
 * @see <a href="http://norvig.com/sudoku.html">Solving Every Sudoku Puzzle</a>
 * 
 * @author ajalon
 */
public class SudokuPuzzle {
	
	/**
	 * A1 A2 A3| A4 A5 A6| A7 A8 A9 
	 * B1 B2 B3| B4 B5 B6| B7 B8 B9
	 * C1 C2 C3| C4 C5 C6| C7 C8 C9 
	 * --------+---------+---------
	 * D1 D2 D3| D4 D5 D6| D7 D8 D9 
	 * E1 E2 E3| E4 E5 E6| E7 E8 E9 
	 * F1 F2 F3| F4 F5 F6| F7 F8 F9 
	 * --------+---------+---------
	 * G1 G2 G3| G4 G5 G6| G7 G8 G9 
	 * H1 H2 H3| H4 H5 H6| H7 H8 H9 
	 * I1 I2 I3| I4 I5 I6| I7 I8 I9
	 */
	
	private static final int boardDim = 9;
	private static final int boardCells = boardDim*boardDim;
	
	private static final String digits = "123456789";
	private static final String rows = "ABCDEFGHI";
	private static final String cols = digits;
	
	private LinkedHashMap<String,String> values = new LinkedHashMap<String,String>(boardCells);
	
	public SudokuPuzzle(String initialGridState) {
		this.parseGridState(initialGridState);
	}

	/**
	 * Parses a 'gridstate' string and sets the 'values' dictionary
	 * appropriately.
	 * 
	 * @param initialGridState
	 *            a string representing the sudoku grid state, where the
	 *            characters 1-9 represent the corresponding digits, the
	 *            characters 0 and . represent an empty square, and all other
	 *            characters are ignored.
	 */
	private void parseGridState(String initialGridState) {
		if (null == initialGridState) {
			throw new NullPointerException("initialGridState is null");
		}
		
		// strip out all other characters, and replace . with 0
		String filteredGridState = initialGridState.replaceAll("[^0-9\\.]", "").replace('.', '0');
		if (boardCells != filteredGridState.length()) {
			throw new IllegalArgumentException(initialGridState + "does not represent a valid sudoku grid.");
		}
		
		// initialize map 
		for (char row : rows.toCharArray()) {
			for (char col : cols.toCharArray()) {
				values.put(label(row,col), digits);
			}
		}
		
		// set values based on gridstate
		String label = "";
		Iterator<String> squaresIter = values.keySet().iterator();
		for (char ch : filteredGridState.toCharArray()) {
			label = squaresIter.next();
			if (ch != '0') {
				values.put(label,""+ch);
			}
		}
	}
	
	public void printGridState(boolean expanded) {
		for (char row : rows.toCharArray()) {
			for (char col : cols.toCharArray()) {
				if (expanded) {
					System.out.printf("%1s %2$9s ",label(row,col),values.get(label(row,col)));
				} else {
					String possibilities = values.get(label(row,col));
					System.out.print(1 == possibilities.length() ? possibilities : " ");
				}
			}
			System.out.println();
		}
	}
	
	private String label(char rowLetter, char colNumber) {
		return "" + rowLetter + colNumber;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Entry<String, String> entry : values.entrySet()) {
			builder.append(String.format("%1$9s", entry.getValue()));
		}
		
		return builder.toString();
	}
	
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		
		if (that instanceof SudokuPuzzle) {
			return (this.toString().equals(that.toString()));
		}
		
		return false;
	}
	
}
