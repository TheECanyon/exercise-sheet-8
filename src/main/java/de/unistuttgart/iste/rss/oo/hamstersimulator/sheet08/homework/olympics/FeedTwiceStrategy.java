package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;


/**
 * Algorithm for the FeedingStrategy to eat two grains per grain storage tile
 * @author Alex, Max, Jannick
 * @version 0.1.0.20210120_1816
 */
public class FeedTwiceStrategy implements FeedingStrategy {
    int grainsTaken = 1;

    /**
     * This method returns true as long as 1 or less grains have been eaten once the hamster entered
     * the grain storage tile. After eating 2 grains the return value is changed to false.
     * @return boolean is it required to eat
     */
    @Override
    public boolean isFeedingRequired() {

	if (grainsTaken==1) {
		grainsTaken++;
	    return true;
	} else if (grainsTaken==2) {
		grainsTaken++;
	    return true;
	} else {
		grainsTaken=1;
	    return false;
	}
    }

}
