package dev.lipam;

import dev.lipam.round.Round;
import dev.lipam.round.RoundCreator;

public class MontyHallParadox {
    public static final int NUMBER_OF_ROUNDS = 50;
    public static final boolean SHOW_GAMES = true;
    public static final boolean ALWAYS_SWITCH_GUESS = true;

    public static void main(String[] args) {
        long countWonRounds = RoundCreator.generate(NUMBER_OF_ROUNDS, SHOW_GAMES).stream()
                .peek(Round::play)
                .filter(Round::isWon)
                .count();
        System.out.println("Won rounds = " + countWonRounds);
        double wonPercentage = (double) countWonRounds / NUMBER_OF_ROUNDS * 100;
        System.out.println("percentage: " + wonPercentage + "%");
    }
}