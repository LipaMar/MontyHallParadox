package dev.lipam.round;

import java.util.List;
import java.util.stream.Stream;

public class RoundCreator {

    public static List<? extends Round> generate(int numberOfRounds, boolean showGames) {
        if (showGames) {
            return Stream.generate(RoundPrinted::new)
                    .limit(numberOfRounds).toList();
        }
        return Stream.generate(Round::new)
                .limit(numberOfRounds).toList();
    }
}
