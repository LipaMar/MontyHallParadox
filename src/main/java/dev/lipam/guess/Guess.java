package dev.lipam.guess;

import dev.lipam.MontyHallParadox;
import dev.lipam.door.Door;

import java.util.List;
import java.util.Random;

public class Guess {

    private static final Random RANDOM = new Random();
    private Door door;

    public Guess(Door door) {
        this.door = door;
    }

    public static Guess makeAGuess(List<Door> doors) {
        List<Door> notOpenedDoors = doors.stream().filter(Door::isNotOpen).toList();
        Door door = getRandomDoor(notOpenedDoors);
        return new Guess(door);
    }

    public Guess switchGuess(List<Door> doors) {
        if (MontyHallParadox.ALWAYS_SWITCH_GUESS) {
            List<Door> lastedDoors = doors.stream()
                    .filter(Door::isNotOpen)
                    .filter(door -> !door.equals(this.door)).toList();
            this.door = getRandomDoor(lastedDoors);
        }
        return this;
    }

    private static Door getRandomDoor(List<Door> lastedDoors) {
        return lastedDoors.stream()
                .skip(RANDOM.nextInt(lastedDoors.size()))
                .findFirst()
                .get();
    }

    public Door getDoor() {
        return door;
    }

}
