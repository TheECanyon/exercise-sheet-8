package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.SimpleHamsterGame;

import java.util.LinkedList;
import java.util.List;

/**
 * Dedicated game to solve the olympic exercises
 */
public class OlympicsHamsterGame extends SimpleHamsterGame {
	List<RunnerHamster> runners;

    /**
     * create an OlympicHamsterGame 
     */
	public OlympicsHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/raceTrackTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
		runners = new LinkedList<RunnerHamster>();
	}

    /**
     * starts a record attempt
     */
    /*@
     @requires paule is initialized
     @ensures recordAttempt finished
     @*/
	@Override
	protected void run() {
		paule.write("Zum Abschluss: Ein Weltrekordversuch! Kann Speedy heute den Rekord brechen?");
		recordAttempt();
	}

    /**
     * implements the strategy for a record run
     */
     /*@
      @ensures speedy reached goal
      @*/
	private void recordAttempt() {
	    RunnerHamster speedy = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		SprinterRacePlan firstStage = new SprinterRacePlan();
		FeedTwiceStrategy feedingStrategy = new FeedTwiceStrategy();
		speedy.setFeedingTactics(feedingStrategy);
         /*@
          @ loop_invariant : speedy has made i actions
          @ decreasing : distance from speedy to first feedzone
          @*/
		while (speedy.getActionsTaken() < 8) {
		    speedy.setRacePlan(firstStage);
		    speedy.executeNextAction();
		}
		
		RunSteadilyRacePlan secondStage = new RunSteadilyRacePlan();
		speedy.setRacePlan(secondStage);
	     /*@
          @ loop_invariant : speedy has made i actions;
          @ decreasing : distance from speedy to goal
          @*/
		while (speedy.getActionsTaken() >= 8 && speedy.getActionsTaken() < 30) {
		    speedy.write("" + speedy.getActionsTaken());
		    speedy.executeNextAction();
		}
	    
	    if (speedy.hasFinished()){
		    speedy.write("Ich habe " + speedy.getActionsTaken() + " Aktionen gebraucht!");
		}
	}

	private void setupTaskC() {
		runners = new LinkedList<RunnerHamster>();
		
		RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		RunnerHamster sprintingRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		
		RacePlan tacticSteady = new RunSteadilyRacePlan();
		steadyRunner.setRacePlan(tacticSteady);
		
		RacePlan tacticSprinting = new SprinterRacePlan();
		sprintingRunner.setRacePlan(tacticSprinting);
		
		runners.add(steadyRunner);
		runners.add(sprintingRunner);
	}
	
	private void setupTaskD() {
		runners = new LinkedList<RunnerHamster>();
		RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		RunnerHamster sprintingRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
		
		RacePlan tacticSteady = new RunSteadilyRacePlan();
		FeedingStrategy tacticFeedOnce = new FeedOnceStrategy();
		steadyRunner.setRacePlan(tacticSteady);
		steadyRunner.setFeedingTactics(tacticFeedOnce);
		
		RacePlan tacticSprinting = new SprinterRacePlan();
		FeedingStrategy tacticFeedTwice = new FeedTwiceStrategy();
		sprintingRunner.setRacePlan(tacticSprinting);
		sprintingRunner.setFeedingTactics(tacticFeedTwice);
		
		runners.add(steadyRunner);
		runners.add(sprintingRunner);
	}
	
	private void race() {
		Race race = new Race(runners);
		race.executeRace();
	}
}
