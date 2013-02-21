package net.ahjota.praxis.bingo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Bingo is a children’s game of chance, sometimes played by adults for fun or
 * money. Each player has a card of numbers arranged in a five-by-five grid with
 * five randomly-chosen numbers from 1 to 15 in the first column, from 16 to 30
 * in the second column, 31 to 45 in the third column, 46 to 60 in the fourth
 * column, and 61 to 75 in the fifth column; the central space is “free” and is
 * considered to be occupied. Then a caller randomly calls numbers from 1 to 75
 * without replacement, each player marking the corresponding number, if it is
 * present on their card, as occupied. The first player to have five occupied
 * numbers in a row horizontally, in a column vertically, or along either of the
 * two major diagonals is the winner.
 * 
 * What is the average number of calls required before a single card achieves
 * bingo? In a large game with five hundred cards in play, what is the average
 * number of calls required before any card achieves bingo?
 * 
 * @see <a href="http://programmingpraxis.com/2009/02/19/bingo/">Programming
 *      Praxis Exercise 3</a>
 * 
 * @author AJ
 */
public class Bingo {

	/* 0-75, where 0 = free space and 1-75 are actual numbers */
	static final int numberSetSize = 76;

	static final int boardSize = 25;

	static final int columnRange = 15;

	static final int colSize = 5;

	static final int cardsToPlay = 500;
	static final int gamesToPlay = 100;

	public static void main(String[] args) {
		int gamesPlayed = 0;
		int totalNumbersCalled = 0;
		
		// create new cards for play
		ArrayList<BingoCard> cards = new ArrayList<BingoCard>(cardsToPlay);
		for (int i = 0; i < cardsToPlay; ++i) {
			cards.add(new BingoCard());
		}
		

		// prepare the number machine, part 1
		ArrayList<Integer> numbersCalled = new ArrayList<Integer>(numberSetSize - 1);
		for (int i = 1; i < numberSetSize; ++i) {
			numbersCalled.add(i);
		}

		// play games!
		while (gamesPlayed < gamesToPlay) {
			// prepare the number machine, part 2
			for (BingoCard card : cards) {
				card.resetCard();
			}
			Collections.shuffle(numbersCalled);

			int i = 0;
			gameLoop:
			for (i = 0; i < numbersCalled.size(); ++i) {
				// for each number called...
				for (BingoCard card : cards) {
					// ...and for each card in play...
					card.mark(numbersCalled.get(i));
					if (card.checkForBingo()) {
						// System.out.println("BINGO! after " + (i+1) + " numbers called");
						// System.out.println("Numbers called: " + numbersCalled.subList(0, i));

						break gameLoop;
					}
				}
			}

			totalNumbersCalled += i;
			++gamesPlayed;
		}

		System.out.println("Total games played: " + gamesToPlay);
		System.out.println("Total numbers called: " + totalNumbersCalled);
		System.out.println("Average numbers called before a BINGO: "
				+ (double)totalNumbersCalled / gamesToPlay);

	}

}
