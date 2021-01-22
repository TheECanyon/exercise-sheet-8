package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/**
 * FeedingStrategy to not eat
 * @author Jannik, Max, Alex
 * @version 0.1.0.20210121_1614
 */
public class FeedNeverStrategy implements FeedingStrategy{

    /**
     * Feeding is never required
     * @return boolean is it required to eat
     */
	@Override
	public boolean isFeedingRequired() {
		return false;
	}

}
