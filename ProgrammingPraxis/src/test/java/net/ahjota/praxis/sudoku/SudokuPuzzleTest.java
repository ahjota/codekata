package net.ahjota.praxis.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuPuzzleTest {

	@Test(expected = NullPointerException.class)
	public final void testConstructorWhereGridStateStringIsNull() {
		new SudokuPuzzle(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testConstructorWhereGridStateStringIsEmpty() {
		new SudokuPuzzle("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testConstructorWhereGridStateStringIsTooShort() {
		new SudokuPuzzle("12345678912345678912345678912345678912345678912345678912345678912345678912345678");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public final void testConstructorWhereGridStateStringIsTooShort2() {
		new SudokuPuzzle("12345678912345678912345678912345678912345678912345678912345678912345678912345678a");
	}
	
	@Test
	public final void testConstructorWithNoEmptySquares() {
		new SudokuPuzzle("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
	}
	
	@Test
	public final void testConstructorWithEmptySquares() {
		new SudokuPuzzle(".................................................................................");
		new SudokuPuzzle("000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		new SudokuPuzzle("123456789123456789123456789123456789123456789123456789123456789123456789123456...");
		new SudokuPuzzle("123456789123456789123456789123456789123456789123456789123456789123456789123456000");
	}
	
	@Test
	public final void testEquals() {
		SudokuPuzzle one, two;
		
		one = new SudokuPuzzle(".................................................................................");
		two = new SudokuPuzzle("000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		assertEquals(one, two);
		
		one = new SudokuPuzzle("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
		two = new SudokuPuzzle("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
		assertEquals(one, two);
		
		two = one;
		assertEquals(one, two);
		
		assertNotEquals(one, null);
		assertNotEquals(one, new Object());
		assertNotEquals(one, "");
		
		two = new SudokuPuzzle("12345678912345678912345678912345678912345678912345678912345678912345678912345678.");
		assertNotEquals(one, two);
	}
}
