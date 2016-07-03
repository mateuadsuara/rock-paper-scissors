import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ComputerPlayerTest {
    @Test
    public void returnsAllDifferentValues() {
        Random random = new Random();
        ComputerPlayer fromPlayer = new ComputerPlayer(random);
        int amountOfChoices = Game.Choice.values().length * 100;

        Set<Game.Choice> returnedChoices = asSet(getSomeChoices(fromPlayer, amountOfChoices));

        assertEquals(allChoices(), returnedChoices);
    }

    @Test
    public void returnsDifferentValuesEveryTime() {
        int amountOfChoices = Game.Choice.values().length * 10;

        List<Game.Choice> first = getSomeChoices(new ComputerPlayer(new Random()), amountOfChoices);
        List<Game.Choice> second = getSomeChoices(new ComputerPlayer(new Random()), amountOfChoices);

        assertNotEquals(first, second);
    }

    @Test
    public void returnsSameValuesWhenInitializedWithSameSeed() {
        int amountOfChoices = Game.Choice.values().length * 10;

        List<Game.Choice> first = getSomeChoices(new ComputerPlayer(new Random(0)), amountOfChoices);
        List<Game.Choice> second = getSomeChoices(new ComputerPlayer(new Random(0)), amountOfChoices);

        assertEquals(first, second);
    }

    private List<Game.Choice> getSomeChoices(Player fromPlayer, int amount) {
        List<Game.Choice> choices = new ArrayList<>(amount);
        for (int i = 0; i < amount; i ++) {
            choices.add(fromPlayer.choose());
        }
        return choices;
    }

    private Set<Game.Choice> asSet(List<Game.Choice> choices) {
        Set<Game.Choice> set = new HashSet<>();
        for (Game.Choice c : choices) {
            set.add(c);
        }
        return set;
    }

    private Set<Game.Choice> allChoices() {
        Set<Game.Choice> allChoices = new HashSet<>();
        for (Game.Choice c : Game.Choice.values()) {
            allChoices.add(c);
        }
        return allChoices;
    }
}