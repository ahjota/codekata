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
		char charTab = 9;
		String charTabs = new String(new char[]{charTab, charTab, charTab, charTab});
		char charQuote = 34;
		char charComma = 44;
		String srcCode[] = {// line 21
				
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
				"		char charTab = 9;",
				"		String charTabs = new String(new char[]{charTab, charTab, charTab, charTab});",
				"		char charQuote = 34;",
				"		char charComma = 44;",
				"		String srcCode[] = {// line 21",
				"",
				"",
				"		};",
				"",
				"		int i;",
				"		for (i = 0; i < 22; ++i) {",
				"			System.out.println(srcCode[i]);// before srcCode definition",
				" 		}",
				"		for (String loc : srcCode) {",
				"			System.out.println(charTabs + charQuote + loc + charQuote + charComma);",
				"		}",
				"		for (i = 22; i < srcCode.length; ++i) {",
				"			System.out.println(srcCode[i]);// after srcCode definition",
				"		}",
				"	}",
				"}"

		};
		
		int i;
		for (i = 0; i < 22; ++i) {
			System.out.println(srcCode[i]);// before srcCode definition
		}
		for (String loc : srcCode) {
			System.out.println(charTabs + charQuote + loc + charQuote + charComma);
		}
		for (i = 22; i < srcCode.length; ++i) {
			System.out.println(srcCode[i]);// after srcCode definition
		}
	}
}
