package net.ahjota.praxis.romannumerals;

/**
 * I    1
 * V    5
 * X    10
 * L    50
 * C    100
 * D    500
 * M    1000
 * <p/>
 * 4    IIII    IV
 * 9    VIIII   IX
 * 40   XXXX    XL
 * 90   LXXXX   XC
 * 400  CCCC    CD
 * 900  DCCCC   CM
 *
 * @author ajalon
 * @see <a href="http://programmingpraxis.com/2009/03/06/roman-numerals/">http://programmingpraxis.com/2009/03/06/roman-numerals/</a>
 */
public class RomanNumeralCalculator {


    public static void main(String[] args) {
        RomanNumeralCalculator rnc = new RomanNumeralCalculator();
        System.out.println(rnc.toDecimal("XV"));//15
        System.out.println(rnc.toDecimal("XXX"));//30
        System.out.println(rnc.toDecimal("CCCLXIX"));//369
        System.out.println(rnc.toDecimal("CDXLVIII"));//448

    }

    public int toDecimal(String numeral) {
        return toDecimal(numeral.toCharArray());
    }

    public int toDecimal(char[] numeral) {
        int result = 0;
        int lastAddend = 0;
        for (char c : numeral) {
            int newAddend = 0;
            switch (c) {
                case 'M':
                    newAddend = 1000;
                    break;
                case 'D':
                    newAddend = 500;
                    break;
                case 'C':
                    newAddend = 100;
                    break;
                case 'L':
                    newAddend = 50;
                    break;
                case 'X':
                    newAddend = 10;
                    break;
                case 'V':
                    newAddend = 5;
                    break;
                case 'I':
                    newAddend = 1;
                    break;
                default:
                    throw new IllegalArgumentException(numeral + " contains invalid numeral '" + c + "'");
            }

            result += newAddend;

            if (lastAddend < newAddend) {
                // subtract lastAddend twice
                result -= (lastAddend*2);
            }

            lastAddend = newAddend;
        }

        return result;
    }

    public String add(String... addends) {
        return null;
    }
}
