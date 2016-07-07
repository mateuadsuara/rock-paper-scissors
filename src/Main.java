import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        run(System.in, System.out, ThreadLocalRandom.current());
    }

    public static void run(InputStream in, PrintStream out, Random random) {
        Game.Choice firstChoice = new HumanPlayer(in, out).choose();
        Game.Choice secondChoice = new ComputerPlayer(random).choose();

        Game.Outcome outcome = new Game().play(firstChoice, secondChoice);

        new Display(out).printOutcome(firstChoice, secondChoice, outcome);
    }
}
