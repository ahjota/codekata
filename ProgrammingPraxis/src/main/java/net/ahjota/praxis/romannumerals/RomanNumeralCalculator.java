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

    public int toDecimal(String numeral) {
        numeral = numeral.trim();
        return toDecimal(numeral.toCharArray());
    }

    private int toDecimal(char[] numeral) {
        int result = 0;
        int lastAddend = 0;
        for (char c : numeral) {
            int newAddend = 0;
            switch (Character.toUpperCase(c)) {
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

    public String toRoman(int value) {
        if (1 > value) {
            throw new IllegalArgumentException("roman numeral notation cannot express zero or negative integers");
        }

        StringBuilder sb = new StringBuilder();

        int remainder = value;
        while (remainder > 0) {
            if (remainder - 1000 >= 0) {
                remainder -= 1000;
                sb.append('M');
            } else if (remainder - 500 >= 0) {
                remainder -= 500;
                sb.append('D');
            } else if (remainder - 100 >= 0) {
                remainder -= 100;
                sb.append('C');
            } else if (remainder - 50 >= 0) {
                remainder -= 50;
                sb.append('L');
            } else if (remainder - 10 >= 0) {
                remainder -= 10;
                sb.append('X');
            } else if (remainder - 5 >= 0) {
                remainder -= 5;
                sb.append('V');
            } else if (remainder - 1 >= 0) {
                remainder -= 1;
                sb.append('I');
            }
        }

        return sb.toString();
    }

    public String add(String... addends) {
        return null;
    }
}
