package net.ahjota.praxis.eratosthenes;

import java.util.HashSet;

/**
 * This implementation uses a single HashSet to store the list of primes. At
 * small values of n it is slower than VectorSieve, but at large values
 * of n it is faster by several orders of magnitude. Probably due to remove()
 * being O(n).
 * 
 * WARN: This is not an actual implementation of the sieve because it sieves
 * almost every number less than n. Regardless, it's still really fast.
 * 
 * 10		58140 ns
 * 1000		.002317 s
 * 10000	.001356 s
 * 100000	.009980 s
 * 1000000	.1420 s
 * 15485863	7.218 s
 * 
 * @author AJ
 * 
 */
public class HashSetSieve implements Sieve {

	static final int NUM_TESTS_PER_N = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSetSieve sieve = new HashSetSieve();
		
		int[] tests = new int[] {
				1
				,10
//				,100
				,1000
				,10000
				,100000
				,1000000
				,15485863
		};
		
		
		for (int test : tests) {
			long totalElapsedTime = 0;
			for (int i = 0; i < NUM_TESTS_PER_N; ++i) {
				totalElapsedTime += sieve.countPrimesLessThanOrEqualTo(test);
			}
			System.out.println("Average time for " + test + " was "
					+ totalElapsedTime / NUM_TESTS_PER_N + " ns");
			System.out.println("or " + totalElapsedTime / NUM_TESTS_PER_N
					/ 1000000000.0 + " s");
		}

	}

	/**
	 * @param n
	 * @return elapsed time in nanoseconds
	 */
	@Override
	public long countPrimesLessThanOrEqualTo(int n) {

		long startTime = System.nanoTime();
		HashSet<Integer> primes = listPrimesLessThanOrEqualTo(n);
		long elapsedTime = (System.nanoTime() - startTime);

		System.out.println("There are " + primes.size() + " primes <= " + n);
		// System.out.println(primes.toString());

		return elapsedTime;
	}

	public static HashSet<Integer> listPrimesLessThanOrEqualTo(int n) {
		HashSet<Integer> primes = new HashSet<Integer>(n);

		if (n < 2) {
			return primes;
		}
		
		// optimization: we only need to consider odd integers > 2
		primes.add(2);
		int largestCandidate = 0;
		for (int i = 3; i <= n; i+=2) {
			primes.add(i);
			largestCandidate = i;
		}

		int lastSieve = (int) Math.sqrt(largestCandidate);

		// optimization: we can stop sifting at the square root of the last
		// element (largest number) in the sieve
		
		for (int i = 3; i <= lastSieve; ++i) {
			// System.out.println("Sifting multiples of " + i);
			// optimization: within each sift, we start removing non-primes
			// beginning with the square of the sifting number
			int sieveStop = largestCandidate / i;
			for (int j = i; j <= sieveStop; ++j) {
				primes.remove(i * j);
			}
			// System.out.println("Sift complete: " + primes.toString());
		}

		return primes;
	}

}