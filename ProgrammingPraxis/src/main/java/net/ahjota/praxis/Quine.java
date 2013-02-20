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
		String charTabs = new String(new char[]{9, 9, 9, 9});
		char charQuote = 34;
		char charComma = 44;
		String srcCode[] = {// line 20
				
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
				"		String charTabs = new String(new char[]{9, 9, 9, 9});",
				"		char charQuote = 34;",
				"		char charComma = 44;",
				"		String srcCode[] = {// line 20",
				"",
				"",
				"		};",
				"",
				"		int i;",
				"		for (i = 0; i < 21; ++i) {",
				"			System.out.println(srcCode[i]);// before srcCode definition",
				" 		}",
				"		for (String loc : srcCode) {",
				"			System.out.println(charTabs + charQuote + loc + charQuote + charComma);",
				"		}",
				"		for (i = 21; i < srcCode.length; ++i) {",
				"			System.out.println(srcCode[i]);// after srcCode definition",
				"		}",
				"	}",
				"}"

		};
		
		int i;
		for (i = 0; i < 21; ++i) {
			System.out.println(srcCode[i]);// before srcCode definition
		}
		for (String loc : srcCode) {
			System.out.println(charTabs + charQuote + loc + charQuote + charComma);
		}
		for (i = 21; i < srcCode.length; ++i) {
			System.out.println(srcCode[i]);// after srcCode definition
		}
	}
}
