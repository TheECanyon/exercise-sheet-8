package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;
/** 
 * offers  a strategy to sprint through the track as fast as possible
 * high energy consumption
 */
public class SprinterRacePlan implements RacePlan {
	/**
	 * Every actions is a three-tile-step, if possible
	 */
    @Override public void nextStep(RunnerHamster hamster) {
	hamster.runHard();
    }
}
