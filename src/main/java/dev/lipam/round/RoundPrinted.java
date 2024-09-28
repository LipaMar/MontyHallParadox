package dev.lipam.round;

import dev.lipam.door.Door;
import dev.lipam.guess.Guess;
import dev.lipam.MontyHallParadox;

import java.util.List;

public class RoundPrinted extends Round {
    @Override
    public void play() {
        super.play();
        if (this.isWon()) {
            System.out.println("--- WIN ---");
        } else {
            System.out.println("--- LOST ---");
        }
    }

    @Override
    protected List<Door> createDoors() {
        List<Door> doors = super.createDoors();
        showDoors(doors);
        return doors;
    }

    @Override
    protected void openOneLosingDoor(Guess guess) {
        super.openOneLosingDoor(guess);
        showDoors(this.getDoors());
    }

    @Override
    protected void guessChanged(Guess guess) {
        super.guessChanged(guess);
        showGuess(guess, getDoors());
    }

    private void showDoors(List<Door> doors) {
        doors.forEach(this::show);
        System.out.println();
    }

    private void show(Door door) {
        if (door.hasWinBehind()) {
            System.out.print("W");
        } else if (door.isOpen()) {
            System.out.print("O");
        } else {
            System.out.print("X");
        }
    }

    private void showGuess(Guess guess, List<Door> doors) {
        if (MontyHallParadox.SHOW_GAMES) {
            doors.forEach(door -> {
                if (door.equals(guess.getDoor())) {
                    System.out.print("^");
                } else {
                    System.out.print(" ");
                }
            });
            System.out.println();
        }
    }

}
