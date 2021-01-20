package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public class FeedOnceStrategy implements FeedingStrategy {
	private boolean hasUsedThisStation = false;

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
