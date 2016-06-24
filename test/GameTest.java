import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void rockVsRockIsADraw() throws Exception {
        InputStream input = new ByteArrayInputStream("ROCK\n".getBytes());
        OutputStream output = new ByteArrayOutputStream();
        Random random = new Random(0);
        Game game = new Game(input, new PrintStream(output), random);

        game.play();

        String expected =
                "Choose: [ROCK, PAPER, SCISSORS]\n" +
                "ROCK vs ROCK\n" +
                "It is a draw.\n";
        assertEquals(expected, output.toString());
    }

}