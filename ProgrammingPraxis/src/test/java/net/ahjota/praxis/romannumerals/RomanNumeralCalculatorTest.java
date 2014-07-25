package net.ahjota.praxis.romannumerals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author ajalon
 */
public class RomanNumeralCalculatorTest {

    static RomanNumeralCalculator fixture;

    @Test(expected = NullPointerException.class)
    public void convertNullToDecimalThrowsException() {
        fixture.toDecimal(null);
    }

    @Test
    public void convertEmptyStringToDecimalReturnsZero() {
        assertEquals(0, fixture.toDecimal(""));
        assertEquals(0, fixture.toDecimal(" "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNonRomanStringToDecimalThrowsException() {
        fixture.toDecimal("MA");
    }

    @Test
    public void convertNumeralRootsToDecimal() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(1, "I");
        numerals.put(5, "V");
        numerals.put(10, "X");
        numerals.put(50, "L");
        numerals.put(100, "C");
        numerals.put(500, "D");
        numerals.put(1000, "M");

        for (Integer number : numerals.keySet()) {
            assertEquals(number.intValue(), fixture.toDecimal(numerals.get(number)));
        }
    }

    @Test
    public void convertLowercaseRootsToDecimal() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(1, "i");
        numerals.put(5, "v");
        numerals.put(10, "x");
        numerals.put(50, "l");
        numerals.put(100, "c");
        numerals.put(500, "d");
        numerals.put(1000, "m");

        for (Integer number : numerals.keySet()) {
            assertEquals(number.intValue(), fixture.toDecimal(numerals.get(number)));
        }
    }

    @Test
    public void convertRomanNumeralsToDecimal() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(3, "III");
        numerals.put(4, "IV");
        numerals.put(8, "VIII");
        numerals.put(9, "IX");
        numerals.put(63, "LXIII");
        numerals.put(444, "CDXLIV");
        numerals.put(1997, "MCMXCVII");
        numerals.put(2001, "MMI");
        numerals.put(2014, "MMXIV");
        numerals.put(9000, "MMMMMMMMM");

        for (Integer number : numerals.keySet()) {
            assertEquals(number.intValue(), fixture.toDecimal(numerals.get(number)));
        }
    }

    @Test
    public void compareAdditiveAndSubtractiveNotations() {
        Map<String, String> matchingNumerals = new HashMap<String, String>();
        matchingNumerals.put("IIII", "IV");
        matchingNumerals.put("VIIII", "IX");
        matchingNumerals.put("XXXX", "XL");
        matchingNumerals.put("LXXXX", "XC");
        matchingNumerals.put("CCCC", "CD");
        matchingNumerals.put("DCCCC", "CM");

        for (String additive : matchingNumerals.keySet()) {
            String subtractive = matchingNumerals.get(additive);
            assertEquals(fixture.toDecimal(additive), fixture.toDecimal(subtractive));
        }
    }

    @Test
    public void convertMixedNotationNumeralToDecimal() {
        assertEquals(4494, fixture.toDecimal("MMMMCCCCXCIIII"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertZeroToRomanThrowsException() {
        // remember, roman notation cannot express zero
        fixture.toRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNegativeNumberToRomanThrowsException() {
        // remember, roman notation cannot express negative numbers
        fixture.toRoman(-1);
    }

    @Test
    public void convertToRomanRoots() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(1, "I");
        numerals.put(5, "V");
        numerals.put(10, "X");
        numerals.put(50, "L");
        numerals.put(100, "C");
        numerals.put(500, "D");
        numerals.put(1000, "M");

        for (Integer number : numerals.keySet()) {
            assertEquals(numerals.get(number), fixture.toRoman(number));
        }
    }

    @Test
    public void convertToRomanNumerals() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(22, "XXII");
        numerals.put(58, "LVIII");
        numerals.put(103, "CIII");
        numerals.put(505, "DV");
        numerals.put(1385, "MCCCLXXXV");
        numerals.put(9000, "MMMMMMMMM");

        for (Integer number : numerals.keySet()) {
            assertEquals(numerals.get(number), fixture.toRoman(number));
        }
    }

    public void convertToSubtractiveRomanNumerals() {
        Map<Integer, String> numerals = new HashMap<Integer, String>();
        numerals.put(4, "IV");
        numerals.put(9, "IX");
        numerals.put(40, "XL");
        numerals.put(90, "XC");
        numerals.put(400, "CD");
        numerals.put(900, "CM");

        for (Integer number : numerals.keySet()) {
            assertEquals(numerals.get(number), fixture.toRoman(number));
        }
    }

    @BeforeClass
    public static void setupClass() {
        fixture = new RomanNumeralCalculator();
    }

}