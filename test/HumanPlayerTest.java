import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class HumanPlayerTest {
    @Test
    public void translatesRock() {
        assertEquals(Game.Choice.ROCK, choosing("ROCK").returnedChoice);
    }

    @Test
    public void translatesPaper() {
        assertEquals(Game.Choice.PAPER, choosing("PAPER").returnedChoice);
    }

    @Test
    public void translatesScissors() {
        assertEquals(Game.Choice.SCISSORS, choosing("SCISSORS").returnedChoice);
    }

    @Test
    public void returnsTheChoiceAfterAnInvalidOne() {
        assertEquals(Game.Choice.SCISSORS, choosing("INVALID\nSCISSORS").returnedChoice);
    }

    @Test
    public void displaysInvalidChoiceWhenInvalidChoice() {
        assertTrue(choosing("INVALID\nROCK").printedOutput.contains("Invalid choice."));
    }

    @Test
    public void doesNotDisplayInvalidChoiceWhenCorrectChoice() {
        assertFalse(choosing("ROCK").printedOutput.contains("Invalid choice."));
    }

    @Test
    public void displaysChooseMenu() {
        assertTrue(choosing("ROCK").printedOutput.contains("Choose: [ROCK, PAPER, SCISSORS]"));
    }

    class HumanPlayerOutput {
        public final Game.Choice returnedChoice;
        public final String printedOutput;

        HumanPlayerOutput(Game.Choice returnedChoice, String printedOutput) {
            this.returnedChoice = returnedChoice;
            this.printedOutput = printedOutput;
        }
    }

    private HumanPlayerOutput choosing(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        HumanPlayer player = new HumanPlayer(inputStream, new PrintStream(output));

        Game.Choice choice = player.choose();
        String printedOutput = output.toString();

        return new HumanPlayerOutput(choice, printedOutput);
    }
}