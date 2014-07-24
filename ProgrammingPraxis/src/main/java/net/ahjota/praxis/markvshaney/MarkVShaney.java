package net.ahjota.praxis.markvshaney;

import java.io.Reader;

/**
 * MarkVShaney generates non-sensical texts using a Markov chain.
 * <p/>
 * In the mid-1980's, Mark V. Shaney posted messages such as this to the Usenet group net.singles:
 * <p/>
 * <pre>I seem to be important. For me, it would have agreed with the
 * technical insight that is dear to me. Because of this, I have no
 * advice for someone in that situation!
 * <p/>
 * Joining Mensa was something I did him one better. I wore a dress skirt
 * a day for one week. I did him one better. I wore a dress skirt a day
 * for a 2 year relationship. I'm wondering if anyone else out there has
 * ever experienced this phenomena, whether it was actually your
 * contention that this is true for me.
 * <p/>
 * I suppose it depends how you felt about someone before you became
 * emotionally attached and therefore "safer" - not to sporting events,
 * but to opera.
 * <p/>
 * I lost 90 lbs a few months during my "flower child" days in high school
 * where, due to her high academic standings, was shunned by many of the
 * tube. The experience really screwed them up - if not their heads,
 * their knees. Why does one have to be the prime measurement of
 * manhood. No?
 * <p/>
 * He was a scrawny, spastic nerd in high school, and I fantasized about
 * such a thing. It all depends on the sidelines, listening to what makes
 * the rest of the guys around her - suddenly finds herself in a situation
 * where guys are asking them out!? But this can result in members of
 * either the person of your dreams (in a larger number of males to
 * females studying the field of engineering), the ratio of males to
 * females is somewhere in the past. And, per the other person.
 * <p/>
 * I find it hard to reconcile the notion that something or someone isn't
 * theirs anymore. I have a date with the woman. Subjectively, I have
 * also acted in this weekend.
 * </pre>
 * However, Shaney wasn't a person. Shaney was a bot created by three Bell Labs researchers -- Bruce Ellis, Rob Pike and Don Mitchell -- that analyzed Usenet postings and then created its own posting. Shaney's writings were quirky, non-sensical, and beloved by many.
 * <p/>
 * Shaney worked by reading a training text and saving each triple of words that appear in the training text in a large table. Then it generates text using a markov chain, starting with two words that appear in the training text and repeatedly writing the third word of the triple, sliding the output window from word to word. The genius of the method is that any two words may appear in the training text with multiple following words, and the generator is free to choose any of them; thus, short fragments of text make sense, but the text as a whole frequently veers from one train of thought to another. A word includes its surrounding punctuation, so that sentence structure and, indirectly, grammar, are built in to the output.
 * <p/>
 * Write a program that implements Shaney.
 *
 * @author ajalon
 */
public interface MarkVShaney {

    public void train(Reader is);

    /**
     * Clears the Markov chain used by this Shaney.
     */
    public void clearMarkovChain();

    /**
     * @param wordCount Minimum number of words the generated text should contain.
     * @return A text string generated from the Mark V. Shaney markov chain, or an empty string if wordCount is set to 0.
     * @throws IllegalStateException if Mark V. Shaney has not consumed a training text.
     */
    public String generate(int wordCount) throws IllegalStateException;

}
