package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public class FeedTwiceStrategy implements FeedingStrategy {
    private boolean hasUsedThisStationOnce = false;
    private boolean hasUsedThisStationTwice = false;

    @Override public boolean isFeedingRequired() {
	if (!hasUsedThisStationOnce) {
	    this.hasUsedThisStationOnce = true;
	    return true;
	} else if (!hasUsedThisStationTwice) {
	    this.hasUsedThisStationTwice = true;
	    return true;
	} else {
	    this.hasUsedThisStationOnce = false;
	    this.hasUsedThisStationTwice = false;
	    return false;
	}
    }

}
