package net.ahjota.praxis.eratosthenes;

import java.util.BitSet;

/**
 * This implementation uses a bit array to represent the list of primes, where
 * the array index is the actual numerical value and the bit value represents
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
public class BitSetSieve extends Sieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BitSetSieve sieve = new BitSetSieve();
		
		int[] tests = new int[] { 1
				// ,10
				, 100
		// ,1000
		// ,10000
		// ,100000
		// ,1000000
		// ,15485863
		 ,100000000
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
		BitSet primes = listPrimesLessThanOrEqualTo(n);
		
		// System.out.println("There are " + primes.cardinality() + " primes <= " + n);
		// System.out.println(primes.toString());
		// System.out.println(primes.previousSetBit(primes.size()));

		return primes.cardinality();
	}

	public static BitSet listPrimesLessThanOrEqualTo(int n) {
		BitSet primes = new BitSet(n);

		if (n < 2) {
			return primes;
		}
		primes.set(2);

		if (n < 3) {
			return primes;
		}

		// optimization: we only need to consider odd integers > 2
		for (int i = 3; i <= n; i += 2) {
			primes.set(i);
		}

		int lastSieve = (int) Math.sqrt(n);

		// optimization: we can stop sifting at the square root of the last
		// element (largest number) in the sieve

		for (int sieve = 3; sieve <= lastSieve; sieve = primes
				.nextSetBit(sieve + 1)) {
			// System.out.println("Sifting multiples of " + sieve);
			// optimization: within each sift, we start removing non-primes
			// beginning with the square of the sifting number
			for (int remove = sieve * sieve; remove <= n; remove += sieve) {
				primes.clear(remove);
			}
			// System.out.println("Sift complete: " + primes.toString());
		}

		return primes;
	}

}