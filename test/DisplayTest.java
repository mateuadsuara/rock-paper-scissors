import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DisplayTest {
    @Test
    public void displaysRockVsPaper() {
        String output = printOutcome(Game.Choice.ROCK, Game.Choice.PAPER, Game.Outcome.LOSE);
        assertTrue(output.contains("ROCK vs PAPER"));
    }

    @Test
    public void displaysScissorsVsRock() {
        String output = printOutcome(Game.Choice.SCISSORS, Game.Choice.ROCK, Game.Outcome.LOSE);
        assertTrue(output.contains("SCISSORS vs ROCK"));
    }

    @Test
    public void displaysALoss() {
        String output = printOutcome(Game.Choice.ROCK, Game.Choice.PAPER, Game.Outcome.LOSE);
        assertTrue(output.contains("You lose :("));
    }

    @Test
    public void displaysAWin() {
        String output = printOutcome(Game.Choice.ROCK, Game.Choice.SCISSORS, Game.Outcome.WIN);
        assertTrue(output.contains("You win!"));
    }

    @Test
    public void displaysADraw() {
        String output = printOutcome(Game.Choice.ROCK, Game.Choice.ROCK, Game.Outcome.DRAW);
        assertTrue(output.contains("It is a draw."));
    }

    private String printOutcome(Game.Choice first, Game.Choice second, Game.Outcome outcome) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        new Display(new PrintStream(output)).printOutcome(first, second, outcome);

        return output.toString();
    }
}