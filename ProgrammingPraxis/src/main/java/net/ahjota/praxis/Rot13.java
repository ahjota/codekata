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
public class ROT13 {

	public static void main(String[] args) {
		Scanner consoleScanner = new Scanner(System.in);

		System.out.println("Input a string below and hit enter to have it encrypted using ROT13.");
		System.out.println("Input an empty string to exit.");

		String input = "";
		do {
			System.out.println(rot13(input));
			input = consoleScanner.nextLine();
		} while (!input.isEmpty());

		// should print "Programming Praxis is fun!"
		System.out.println(rot13("Cebtenzzvat Cenkvf vf sha!"));
		
	}

	public static String rot13(String str) {
		if (str.isEmpty()) {
			return str;
		}
		
		StringBuilder rot13 = new StringBuilder(str.length());
		for (char ch : str.toCharArray()) {
			if (Character.isLetter(ch)) {// A-Z,a-z:65-90,97:122
				int ch13 = ch + 13;
				if (Character.isUpperCase(ch)) {// A-Z:65-90
					ch13 -= 65;
					ch13 %= 26;
					ch13 += 65;
				} else if (Character.isLowerCase(ch)) {// a-z:97-122
					ch13 -= 97;
					ch13 %= 26;
					ch13 += 97;
				}
				rot13.append((char)(ch13));
			}
			 else {
				rot13.append(ch);
			}
		}

		return rot13.toString();
	}

}
