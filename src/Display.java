import java.io.PrintStream;

class Display {
    public static void printOutcome(PrintStream output, Game.Choice first, Game.Choice second, Game.Outcome outcome) {
        output.println(first + " vs " + second);
        output.println(outcomeToString(outcome));
    }

    private static String outcomeToString(Game.Outcome outcome) {
        switch (outcome) {
            case WIN:  return "You win!";
            case LOSE: return "You lose :(";
            case DRAW: return "It is a draw.";
        }
        throw new IllegalArgumentException();
    }
}
