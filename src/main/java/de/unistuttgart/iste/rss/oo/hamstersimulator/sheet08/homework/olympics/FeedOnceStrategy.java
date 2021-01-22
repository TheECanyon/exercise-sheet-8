package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/**
 * Algorithm for the FeedingStrategy to eat one grain per grain storage tile
 */
public class FeedOnceStrategy implements FeedingStrategy {
	private boolean hasUsedThisStation = false;
	
    /**
     * Returns that one grain per feedzone is required
     * @return boolean is it required to eat
     */
	@Override
	public boolean isFeedingRequired() {
	    if (!hasUsedThisStation) {
		this.hasUsedThisStation = true;
		return true;
	    } else {
		this.hasUsedThisStation = false;
		return false;
	    }
	}

}
