import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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

    public void play() {
        Choice humanChoice = askChoice();
        Choice computerChoice = randomChoice();

        Outcome outcome = humanChoice.vs(computerChoice);

        printChoices(humanChoice, computerChoice);
        printOutcome(outcome);
    }

    private void printChoices(Choice human, Choice computer) {
        System.out.println(human + " vs " + computer);
    }

    private Choice askChoice() {
        System.out.println("Choose: ROCK, PAPER, SCISSORS");

        Choice choice = choiceFromString(new Scanner(System.in).nextLine());

        if (choice == null) {
            System.out.println("Invalid choice.");
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
        Integer choiceIndex = ThreadLocalRandom.current().nextInt(0, Choice.values().length);
        return Choice.values()[choiceIndex];
    }

    private void printOutcome(Outcome outcome) {
        System.out.println(outcomeToString(outcome));
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
