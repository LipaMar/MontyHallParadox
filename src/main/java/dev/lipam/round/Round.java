package dev.lipam.round;

import dev.lipam.door.Door;
import dev.lipam.guess.Guess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {
    private static final Random RANDOM = new Random();
    public static final int NUMBER_OF_DOORS = 3;
    private boolean won = false;
    private Guess guess;
    private List<Door> doors;

    public boolean isWon() {
        return won;
    }

    public void play() {
        doors = createDoors();
        guessChanged(Guess.makeAGuess(doors));
        openOneLosingDoor(guess);
        guessChanged(guess.switchGuess(doors));
        won = guess.getDoor().hasWinBehind();
    }

    public List<Door> getDoors() {
        return doors;
    }

    protected void guessChanged(Guess guess) {
        this.guess = guess;
    }


    protected List<Door> createDoors() {
        List<Door> doors = new ArrayList<>();
        int winner = RANDOM.nextInt(NUMBER_OF_DOORS);
        for (int i = 0; i < NUMBER_OF_DOORS; i++) {
            doors.add(new Door(i == winner));
        }
        return doors;
    }

    protected void openOneLosingDoor(Guess guess) {
        doors.stream()
                .filter(Door::isNotOpen)
                .filter(door -> !door.equals(guess.getDoor()))
                .filter(door -> !door.hasWinBehind())
                .findAny()
                .get()
                .open();
    }
}
