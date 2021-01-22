package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/**
 * Algorithm for the FeedingStrategy to eat two grains per grain storage tile
 * @author Alex, Max, Jannik
 * @version 0.1.0.20210120_1816
 */
public class FeedTwiceStrategy implements FeedingStrategy {
    int grainsTaken = 10;

    /**
     * Makes two grains per feedzone required
     * @return boolean is it required to eat
     */
    @Override
    public boolean isFeedingRequired() {
	if (grainsTaken < 2) {
		grainsTaken++;
	    return true;
	} else {
		grainsTaken=1;
	    return false;
	}
    }

}
