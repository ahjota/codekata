package net.ahjota.praxis.eratosthenes;

import java.util.Vector;

/**
 * This implementation uses a single Vector to store the list of primes. It is
 * slow as hell due to removeElement() being at least O(n).
 * 
 * 10		53533 ns
 * 1000		.0018701 s
 * 10000	.055063 s
 * 100000	6.5583 s
 * 
 * @author AJ
 * 
 */
public class VectorSieve extends Sieve {

	static final int NUM_TESTS_PER_N = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorSieve sieve = new VectorSieve();
		
		int[] tests = new int[] {
				1
				,10
//				,100
				,1000
				,10000
				,100000
//				,1000000
//				,15485863
		};
		
		
		for (int test : tests) {
			long result = sieve.countPrimesLessThanOrEqualTo(test);
			System.out.println("There are " + result + " primes <= " + test);
		}

	}

	/**
	 * @param n
	 * @return number of primes
	 */
	public long countPrimesLessThanOrEqualTo(int n) {
		Vector<Integer> primes = listPrimesLessThanOrEqualTo(n);

//		System.out.println("There are " + primes.size() + " primes <= " + n);
//		System.out.println(primes.toString());

		return primes.size();
	}

	public Vector<Integer> listPrimesLessThanOrEqualTo(int n) {
		Vector<Integer> primes = new Vector<Integer>(n);

		if (n < 2) {
			return primes;
		}
		
		// optimization: we only need to consider odd integers > 2
		primes.add(2);
		for (int i = 3; i <= n; i+=2) {
			primes.add(i);
		}
//		System.out.println("Fill complete: " + primes.toString());
		int lastSieve = (int) Math.sqrt(n);
		
		// optimization: we can stop sifting at the square root of the last
		// element (largest number) in the sieve
		for (int i = 0; i < lastSieve; ++i) {
			int sieve = primes.get(i);
//			System.out.println("Sifting multiples of " + sieve);
			// optimization: within each sift, we start removing non-primes
			// beginning with the square of the sifting number
			for (int j = sieve * sieve; j <= n; j += sieve) {
				primes.removeElement(j);
			}
//			System.out.println("Sift complete: " + primes.toString());
		}

		return primes;
	}

}