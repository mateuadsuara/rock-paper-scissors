import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void rockVsRockIsADraw() throws Exception {
        DisplaySpy spy = new DisplaySpy();
        Game game = new Game(
                new PlayerStub(Game.Choice.ROCK),
                new PlayerStub(Game.Choice.ROCK),
                spy);

        game.play();

        assertEquals(Game.Choice.ROCK, spy.lastCall.first);
        assertEquals(Game.Choice.ROCK, spy.lastCall.second);
        assertEquals(Game.Outcome.DRAW, spy.lastCall.outcome);
    }

}