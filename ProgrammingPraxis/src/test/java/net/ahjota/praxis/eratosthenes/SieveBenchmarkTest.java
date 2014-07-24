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

	private static int n = 10000;//TODO increase to 15485863 or higher

//	@Test
	public final void loadTestVectorSieve() {loadTestSieve(new VectorSieve()); }

	@Test
	public final void loadTestBooleanArrayListSieve() {
		loadTestSieve(new BooleanArrayListSieve());
	}

    @Test
    public final void loadTestBooleanArrayListSieveWithSieveSkip() { loadTestSieve(new BooleanArrayListSieveWithEvenSkip()); };

	@Test
	public final void loadTestBooleanArraySieveWithEvenSkip() {
		loadTestSieve(new BooleanArraySieveWithEvenSkip());
	}

    @Test
    public final void loadTestBooleanArraySieve() {
        loadTestSieve(new BooleanArraySieve());
    }
	
	@Test
	public final void loadTestBitSetSieve() {
		loadTestSieve(new BitSetSieve());
	}
	
	protected void loadTestSieve(Sieve sieve) {
		sieve.countPrimesLessThanOrEqualTo(n);
	}

}
