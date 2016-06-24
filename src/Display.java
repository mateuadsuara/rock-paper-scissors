import java.io.PrintStream;

class Display {
    private PrintStream output;

    public Display(PrintStream output) {
        this.output = output;
    }

    public void printOutcome(Game.Choice first, Game.Choice second, Game.Outcome outcome) {
        output.println(first + " vs " + second);
        output.println(outcomeToString(outcome));
    }

    private String outcomeToString(Game.Outcome outcome) {
        switch (outcome) {
            case WIN:  return "You win!";
            case LOSE: return "You lose :(";
            case DRAW: return "It is a draw.";
        }
        throw new IllegalArgumentException();
    }
}
