import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void rockVsRockIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.ROCK, Game.Choice.ROCK).outcome);
    }

    @Test
    public void paperVsPaperIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.PAPER, Game.Choice.PAPER).outcome);
    }

    @Test
    public void scissorsVsScissorsIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.SCISSORS, Game.Choice.SCISSORS).outcome);
    }

    @Test
    public void paperVsRockIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.PAPER, Game.Choice.ROCK).outcome);
    }

    @Test
    public void rockVsPaperIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.ROCK, Game.Choice.PAPER).outcome);
    }

    @Test
    public void rockVsScissorsIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.ROCK, Game.Choice.SCISSORS).outcome);
    }

    @Test
    public void scissorsVsRockIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.SCISSORS, Game.Choice.ROCK).outcome);
    }

    @Test
    public void scissorsVsPaperIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.SCISSORS, Game.Choice.PAPER).outcome);
    }

    @Test
    public void paperVsScissorsIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.PAPER, Game.Choice.SCISSORS).outcome);
    }

    @Test
    public void sendsFirstChoiceToDisplay() throws Exception {
        assertEquals(Game.Choice.ROCK, playGame(Game.Choice.ROCK, Game.Choice.PAPER).first);
        assertEquals(Game.Choice.PAPER, playGame(Game.Choice.PAPER, Game.Choice.SCISSORS).first);
        assertEquals(Game.Choice.SCISSORS, playGame(Game.Choice.SCISSORS, Game.Choice.ROCK).first);
    }

    @Test
    public void sendsSecondChoiceToDisplay() throws Exception {
        assertEquals(Game.Choice.ROCK, playGame(Game.Choice.SCISSORS, Game.Choice.ROCK).second);
        assertEquals(Game.Choice.PAPER, playGame(Game.Choice.ROCK, Game.Choice.PAPER).second);
        assertEquals(Game.Choice.SCISSORS, playGame(Game.Choice.PAPER, Game.Choice.SCISSORS).second);
    }

    private DisplaySpy.Call playGame(Game.Choice first, Game.Choice second) {
        DisplaySpy spy = new DisplaySpy();
        Game game = new Game();

        Game.Outcome outcome = game.play(first, second);
        spy.printOutcome(first, second, outcome);

        return spy.lastCall;
    }
}