package net.ahjota.praxis.eratosthenes;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests the SieveOfEratosthenes implementations.
 * 
 * @author ajalon
 *
 */
public class SieveTest {

	static final int ITERATIONS_PER_TEST = 10;
	
	/**
	 * Test method for {@link net.ahjota.praxis.eratosthenes.VectorSieve#countPrimesLessThanOrEqualTo(int)}.
	 */
	@Test
	public final void loadTestVectorSieve() {
		loadTestSieve(new VectorSieve(), 10000);
	}
	
	/**
	 * Test method for {@link net.ahjota.praxis.eratosthenes.BooleanArrayListSieve#countPrimesLessThanOrEqualTo(int)}.
	 */
	@Test
	public final void loadTestBooleanArrayListSieve() {
		loadTestSieve(new BooleanArrayListSieve(), 100000000-1);
	}
	
	/**
	 * Test method for {@link net.ahjota.praxis.eratosthenes.BooleanArraySieve#countPrimesLessThanOrEqualTo(int)}.
	 */
	@Test
	public final void loadTestBooleanArraySieve() {
		loadTestSieve(new BooleanArraySieve(), Integer.MAX_VALUE);
	}
	
	/**
	 * Test method for {@link net.ahjota.praxis.eratosthenes.BitSetSieve#countPrimesLessThanOrEqualTo(int)}.
	 */
	@Test
	public final void loadTestBitSetSieve() {
		loadTestSieve(new BitSetSieve(), Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param sieve implementation of Sieve
	 * @param systemLimit set this to the upper limit of 'n' for this system,
	 * if you wish to avoid issues re: heap space or execution time
	 */
	protected void loadTestSieve(Sieve sieve, int systemLimit) {
		System.out.println("Performance testing " + sieve.getClass().getSimpleName());
		Map<Integer, Integer> tests = new LinkedHashMap<Integer, Integer>();
		tests.put(1,0);
		tests.put(2,1);
		tests.put(3,2);
		tests.put(5,3);
		tests.put(10,4);
		tests.put(100,25);
		tests.put(1000,168);
		tests.put(10000,1229);
		tests.put(100000,9592);
		tests.put(15485863,1000000);
		tests.put(100000000,5761455);
		
		
		long startTime = 0, totalElapsedTime = 0;
		double averageElapsedTime = 0.0;
		
		for (Integer upperLimit : tests.keySet()) {
			// sk
			if (upperLimit > systemLimit) {
				continue;
			}
			
			totalElapsedTime = 0;
			for (int i=0; i<ITERATIONS_PER_TEST; ++i) {
				startTime = System.nanoTime();
				long result = sieve.countPrimesLessThanOrEqualTo(upperLimit);
				totalElapsedTime += System.nanoTime() - startTime;
				assertEquals(tests.get(upperLimit).longValue(), result);
			}
			averageElapsedTime = (double)totalElapsedTime / (double)ITERATIONS_PER_TEST;
			System.out.println("n=" + upperLimit + "\tt:"
					+ averageElapsedTime + " ns\tt2:"
					+ averageElapsedTime / 1000000000.0 + " s");
		}
	}

}
