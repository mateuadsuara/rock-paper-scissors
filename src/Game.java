import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    enum Outcome {
        WIN, LOSE, DRAW
    }

    enum Choice {
        ROCK, PAPER, SCISSORS;

        public Outcome vs(Choice other) {
            if (this.beats(other)) return Outcome.WIN;
            if (other.beats(this)) return Outcome.LOSE;
            return Outcome.DRAW;
        }

        public boolean beats(Choice other) {
            return this == ROCK && other == SCISSORS ||
                    this == PAPER && other == ROCK ||
                    this == SCISSORS && other == PAPER;
        }
    }

    private final InputStream input;
    private final PrintStream output;
    private final Random random;

    public Game(InputStream input, PrintStream output, Random random) {
        this.input = input;
        this.output = output;
        this.random = random;
    }

    public void play() {
        Choice humanChoice = askChoice();
        Choice computerChoice = randomChoice();

        Outcome outcome = humanChoice.vs(computerChoice);

        printChoices(humanChoice, computerChoice);
        printOutcome(outcome);
    }

    private void printChoices(Choice human, Choice computer) {
        output.println(human + " vs " + computer);
    }

    private Choice askChoice() {
        output.println("Choose: ROCK, PAPER, SCISSORS");

        Choice choice = choiceFromString(new Scanner(input).nextLine());

        if (choice == null) {
            output.println("Invalid choice.");
            return askChoice();
        }
        return choice;
    }

    private Choice choiceFromString(String string) {
        for (Choice choice : Choice.values()) {
            if (choice.toString().equals(string))
                return choice;
        }

        return null;
    }

    private Choice randomChoice() {
        Integer choiceIndex = random.nextInt(Choice.values().length);
        return Choice.values()[choiceIndex];
    }

    private void printOutcome(Outcome outcome) {
        output.println(outcomeToString(outcome));
    }

    private String outcomeToString(Outcome outcome) {
        switch (outcome) {
            case WIN:  return "You win!";
            case LOSE: return "You lose :(";
            case DRAW: return "It is a draw.";
        }
        throw new IllegalArgumentException();
    }
}
