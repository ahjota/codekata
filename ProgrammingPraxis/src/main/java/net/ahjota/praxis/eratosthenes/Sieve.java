package net.ahjota.praxis.eratosthenes;

/**
 * Calculates the number of primes less than or equal to a given value n,
 * utilizing the Sieve of Eratosthenes with several optimizations.
 * 
 * @see <a href="http://programmingpraxis.com/2009/02/19/sieve-of-eratosthenes/"
 *      >Programming Praxis Exercise 2</a>
 * 
 * @see <a href="http://primes.utm.edu/howmany.shtml">How Many Primes Are
 *      There?</a>
 * 
 * @author ajalon
 * 
 */
public interface Sieve {

	public long countPrimesLessThanOrEqualTo(int n);

}
