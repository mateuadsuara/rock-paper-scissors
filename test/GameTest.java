import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void rockVsRockIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.ROCK, Game.Choice.ROCK));
    }

    @Test
    public void paperVsPaperIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.PAPER, Game.Choice.PAPER));
    }

    @Test
    public void scissorsVsScissorsIsSentAsADrawOutcome() throws Exception {
        assertEquals(Game.Outcome.DRAW, playGame(Game.Choice.SCISSORS, Game.Choice.SCISSORS));
    }

    @Test
    public void paperVsRockIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.PAPER, Game.Choice.ROCK));
    }

    @Test
    public void rockVsPaperIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.ROCK, Game.Choice.PAPER));
    }

    @Test
    public void rockVsScissorsIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.ROCK, Game.Choice.SCISSORS));
    }

    @Test
    public void scissorsVsRockIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.SCISSORS, Game.Choice.ROCK));
    }

    @Test
    public void scissorsVsPaperIsSentAsAWinOutcome() throws Exception {
        assertEquals(Game.Outcome.WIN, playGame(Game.Choice.SCISSORS, Game.Choice.PAPER));
    }

    @Test
    public void paperVsScissorsIsSentAsALoseOutcome() throws Exception {
        assertEquals(Game.Outcome.LOSE, playGame(Game.Choice.PAPER, Game.Choice.SCISSORS));
    }

    private Game.Outcome playGame(Game.Choice first, Game.Choice second) {
        return new Game().play(first, second);
    }
}