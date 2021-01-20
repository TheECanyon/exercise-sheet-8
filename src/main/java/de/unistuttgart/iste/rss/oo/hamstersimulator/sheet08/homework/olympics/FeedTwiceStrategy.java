package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public class FeedTwiceStrategy implements FeedingStrategy {
    int grainsTaken = 1;
    @Override public boolean isFeedingRequired() {

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
