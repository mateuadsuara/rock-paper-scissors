import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        run(System.in, System.out, ThreadLocalRandom.current());
    }

    public static void run(InputStream in, PrintStream out, Random random) {
        Game.Choice firstChoice = HumanPlayer.choose(in, out);
        Game.Choice secondChoice = ComputerPlayer.choose(random);

        Game.Outcome outcome = Game.play(firstChoice, secondChoice);

        Display.printOutcome(out, firstChoice, secondChoice, outcome);
    }
}
