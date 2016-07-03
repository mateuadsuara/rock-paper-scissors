import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    @Test
    public void rockVsRockIsADraw() throws Exception {
        InputStream input = new ByteArrayInputStream("ROCK\n".getBytes());
        OutputStream output = new ByteArrayOutputStream();
        Random random = new Random(0);
        PrintStream printStream = new PrintStream(output);
        Game game = new Game(new HumanPlayer(input, printStream), new ComputerPlayer(random), new Display(printStream));

        game.play();

        String expected =
                "Choose: [ROCK, PAPER, SCISSORS]\n" +
                        "ROCK vs ROCK\n" +
                        "It is a draw.\n";
        assertEquals(expected, output.toString());
    }
}
