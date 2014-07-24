package net.ahjota.praxis.eratosthenes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This implementation uses a boolean arraylist to represent the list of primes, where
 * the array index is the actual numerical value and the boolean value represents
 * whether said value is prime.
 * 
 * 10		14037 ns
 * 1000		4.5051E-4 s
 * 10000	.0011299 s
 * 100000	.0010647 s
 * 1000000	.0081519 s
 * 15485863	.11725 s
 * 
 * 100000000	1.3224 s
 * 1000000000	15.037 s
 *
 * @author AJ
 * 
 */
public class BooleanArrayListSieve implements Sieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BooleanArrayListSieve sieve = new BooleanArrayListSieve();
		
		int[] tests = new int[] { 1
				// ,10
				, 100
		 ,1000
		 ,10000
		// ,100000
		// ,1000000
		// ,15485863
		// ,100000000
		// ,1000000000
		};
		
		for (int test : tests) {
			long result = sieve.countPrimesLessThanOrEqualTo(test);
			System.out.println("There are " + result + " primes <= " + test);
		}

	}

	/**
	 * @param n
	 * @return number of primes <= n
	 */
	@Override
	public long countPrimesLessThanOrEqualTo(int n) {
		ArrayList<Boolean> primes = listPrimesLessThanOrEqualTo(n);
		
		// System.out.println("There are " + primes.cardinality() + " primes <= " + n);
		// System.out.println(primes.toString());
		// System.out.println(primes.previousSetBit(primes.size()));

		return Collections.frequency(primes, true);
	}

	protected static ArrayList<Boolean> listPrimesLessThanOrEqualTo(int n) {
		ArrayList<Boolean> primes = new ArrayList<Boolean>(n+1);// to avoid one-off errors
		for (int i=0; i<n+1; ++i)
			primes.add(false);

		if (n < 2) {
			return primes;
		}
		primes.set(2, true);

		if (n < 3) {
			return primes;
		}

		// optimization: we only need to consider odd integers > 2
		for (int i = 3; i <= n; i += 2) {
			primes.set(i, true);
		}

		// optimization: we can stop sifting at the square root of the last
		// element (largest number) in the sieve
        int lastSieve = (int) Math.sqrt(n);
		for (int sieve = 3; sieve <= lastSieve; ++sieve) {
			if (primes.get(sieve)) {
			// System.out.println("Sifting multiples of " + sieve);
			// optimization: for each sift, we have already determined primality of all
			// candidates less than the square of the sift number, so we can start
			// removing non-primes beginning with the square of the sift number
				for (int remove = sieve * sieve; remove <= n; remove += sieve) {
					primes.set(remove, false);
				}
			// System.out.println("Sift complete: " + primes.toString());
			}
		}

		return primes;
	}
	
}