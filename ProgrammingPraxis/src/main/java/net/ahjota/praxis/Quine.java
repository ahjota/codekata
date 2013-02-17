package net.ahjota.praxis;

/**
 * A program that takes no input and generates a copy of its own source text as
 * its complete output.
 * 
 * @see <a
 *      href="http://programmingpraxis.com/2009/02/20/a-self-reproducing-program
 *      /
 *      ">http://programmingpraxis.com/2009/02/20/a-self-reproducing-program/</a
 *      >
 * 
 * @author AJ
 */
public class Quine {
	public static void main(String[] args) {
		int charQuote = 34;
		String srcCode[] = {// line 18
				"package net.ahjota.praxis; ",
				"",
				"/**",
				" * A program that takes no input and generates a copy of its own source text as",
				" * its complete output.",
				" * ",
				" * @see <a",
				" *      href=\"http://programmingpraxis.com/2009/02/20/a-self-reproducing-program",
				" *      /",
				" *      \">http://programmingpraxis.com/2009/02/20/a-self-reproducing-program/</a",
				" *      >",
				" * ",
				" * @author AJ",
				" */",
				"public class Quine {",
				"	public static void main(String[] args) {",
				"		int charQuote = 34;",
				"		String srcCode[] = {// line 18",
				"...",
				"	}",
				"}"
		};// line 39
		
		int i;
		for (i = 0; i < 18; ++i) {
			System.out.println(srcCode[i]);
		}
		for (String loc : srcCode) {
			System.out.println(loc);
		}
		for (i = 39; i < srcCode.length; ++i) {
			System.out.println(srcCode[i]);
		}
	}
}
