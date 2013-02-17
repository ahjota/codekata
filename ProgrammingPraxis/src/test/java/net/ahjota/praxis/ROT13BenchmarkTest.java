package net.ahjota.praxis;

import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;

/**
 * Tests the SieveOfEratosthenes implementations.
 * 
 * @author ajalon
 *
 */
public class ROT13BenchmarkTest extends AbstractBenchmark {
	
	private static String testString = "Cebtenzzvat Cenkvf vf sha!";
	
	@Test
	public final void loadTestVectorSieve() {
		for (int i=0; i<2000000; ++i) {
			ROT13.rot13(testString);
		}
	}

}
