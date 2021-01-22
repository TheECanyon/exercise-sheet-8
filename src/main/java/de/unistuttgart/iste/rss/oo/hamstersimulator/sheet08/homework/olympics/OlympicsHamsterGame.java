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
	    paule.write("Willkommen zum ersten Rennen des Tages!");
	    setupTaskC();
	    race();

	    paule.write("Und nun folgt das zweite Rennen!");
	    setupTaskD();
	    race();

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
	    final RunnerHamster speedy = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
	    final RacePlan sprintTactic = new SprinterRacePlan();
	    final RacePlan runTactic = new RunSteadilyRacePlan();
	    final FeedTwiceStrategy feedingStrategy = new FeedTwiceStrategy();

	    speedy.setFeedingTactics(feedingStrategy);
	    speedy.setRacePlan(runTactic);
	    /*@
	      @ loop_invariant speedy made i Actions
	      @ decreasing distance to goal
	      @*/
	    while(!speedy.hasFinished()){
	        speedy.executeNextAction();
		if (speedy.getActionsTaken() == 22){
		    speedy.setRacePlan(sprintTactic);
		}
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
