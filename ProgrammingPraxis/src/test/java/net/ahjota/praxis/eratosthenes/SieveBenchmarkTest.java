package net.ahjota.praxis.eratosthenes;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;

/**
 * Tests the SieveOfEratosthenes implementations.
 * 
 * @author ajalon
 *
 */
public class SieveBenchmarkTest extends AbstractBenchmark {
	
	private static VectorSieve vectorSieve = new VectorSieve();
	private static BooleanArrayListSieve booleanArrayListSieve = new BooleanArrayListSieve();
	private static BooleanArraySieve booleanArraySieve = new BooleanArraySieve();
	private static BitSetSieve bitSetSieve = new BitSetSieve();
	
	private static int n = 50000;//TODO increase to 15485863 or higher
	
	@Test
	public final void loadTestVectorSieve() {
		loadTestSieve(vectorSieve);
	}
	
	@Test
	public final void loadTestBooleanArrayListSieve() {
		loadTestSieve(booleanArrayListSieve);
	}

	@Test
	public final void loadTestBooleanArraySieve() {
		loadTestSieve(booleanArraySieve);
	}
	
	@Test
	public final void loadTestBitSetSieve() {
		loadTestSieve(bitSetSieve);
	}
	
	protected void loadTestSieve(Sieve sieve) {
		sieve.countPrimesLessThanOrEqualTo(n);
	}

}
