package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/** 
 * offers  a strategy to sprint through the track as fast as possible
 * high energy consumption
 */
public class SprinterRacePlan implements RacePlan {
	/**
	 * Every actions is a three-tile-step, if possible
	 */
    @Override public void nextStep(final RunnerHamster hamster) {
	if (hamster.getEnergyRemaining() >= 3){
	    hamster.runHard();
	} else {
	    hamster.runSlowly();
	}
    }
}
