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

	public static char[] rot13(String str) {
		return rot13(str.toCharArray());
	}
	
	public static char[] rot13(char[] str) {
		int ch = 0, ch13 = 0;
		for (int i=0; i<str.length; ++i) {
			ch = str[i];
			if (Character.isLetter(ch)) {// A-Z,a-z:65-90,97:122
				ch13 = ch + 13;
				if (Character.isUpperCase(ch)) {// A-Z:65-90
					ch13 -= 65;
					ch13 %= 26;
					ch13 += 65;
				} else if (Character.isLowerCase(ch)) {// a-z:97-122
					ch13 -= 97;
					ch13 %= 26;
					ch13 += 97;
				}
				str[i] = (char)ch13;
			}
		}

		return str;
	}

}
