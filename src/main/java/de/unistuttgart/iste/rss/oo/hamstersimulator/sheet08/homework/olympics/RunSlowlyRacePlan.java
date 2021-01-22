package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/** 
 * offers  a strategy to walk through the track
 * No need of energy
 */
public class RunSlowlyRacePlan implements RacePlan {
    /**
     * Every Action is a one-tile-step
     */
	@Override
	public void nextStep(RunnerHamster hamster) {
	    hamster.runSlowly();
	}

}
