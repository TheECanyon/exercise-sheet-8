package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/**
 * interface for possible feeding strategies
 * @author Max, Alex, Jannik
 * @version 0.1.0.20210121_1612
 */
public interface FeedingStrategy {

	/**
	 * returns whether or not the current feeding zone a hamster is situated on should be used.
	 * only call this method while the hamster is on a feeding zone!
	 * @return boolean, true if the hamster should use the feeding zone, false if not
	 */
	boolean isFeedingRequired();
}
