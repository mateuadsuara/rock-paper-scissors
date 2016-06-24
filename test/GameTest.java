import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void rockVsRockIsADraw() throws Exception {
        InputStream input = new ByteArrayInputStream("ROCK\n".getBytes());
        OutputStream output = new ByteArrayOutputStream();
        PrintStream printOutput = new PrintStream(output);
        HumanPlayer humanPlayer = new HumanPlayer(input, printOutput);

        Random random = new Random(0);
        ComputerPlayer computerPlayer = new ComputerPlayer(random);

        Display display = new Display(printOutput);
        Game game = new Game(humanPlayer, computerPlayer, display);

        game.play();

        String expected =
                "Choose: [ROCK, PAPER, SCISSORS]\n" +
                "ROCK vs ROCK\n" +
                "It is a draw.\n";
        assertEquals(expected, output.toString());
    }

}