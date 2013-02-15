package net.ahjota.praxis;

import java.util.Scanner;

/**
 * Implements the ROT13 cypher.
 * 
 * @see <a
 *      href="http://programmingpraxis.com/2009/02/20/rot13/">http://programmingpraxis.com/2009/02/20/rot13/http://programmingpraxis.com/2009/02/20/rot13/</a>
 * 
 * @author AJ
 */
public class Rot13 {

	public static void main(String[] args) {
		Scanner consoleScanner = new Scanner(System.in);

		System.out.println("Input a string below and hit enter to have it encrypted using ROT13.");
		System.out.println("Input an empty string to exit.");

		String input = "";
		do {
			input = consoleScanner.nextLine();
			System.out.println(rot13(input));
		} while (!input.isEmpty());

	}

	public static String rot13(String str) {
		// TODO Not yet implemented
		if (str.isEmpty()) {
			return str;
		}

		return str;
	}

}
