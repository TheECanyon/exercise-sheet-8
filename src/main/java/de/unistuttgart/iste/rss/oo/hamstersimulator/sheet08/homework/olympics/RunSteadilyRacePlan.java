package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/** 
 * offers  a strategy to run through the track
 * a balance between speed and energyconsumption
 */
public class RunSteadilyRacePlan implements RacePlan{
	
	/**
	 * Every actions is a two-tile-step, if possible
	 */
	@Override
	public void nextStep(RunnerHamster hamster) {
	    hamster.runSteadily();
	}
}
