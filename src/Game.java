import java.util.Optional;
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
        Choice humanChoice = ask();
        Choice computerChoice = randomChoice();
        printComputerChoice(computerChoice);
        Outcome outcome = humanChoice.vs(computerChoice);
        print(outcome);
    }

    private void printComputerChoice(Choice computerChoice) {
        System.out.println("vs " + toString(computerChoice));
    }

    private Choice ask() {
        System.out.println("Choose: rock, paper, scissors");
        String answer = new Scanner(System.in).nextLine();
        Optional<Choice> choice = fromString(answer);
        return choice.orElseGet(this::ask);
    }

    private String toString(Choice choice) {
        return choice.toString().toLowerCase();
    }

    private Optional<Choice> fromString(String string) {
        String cleanString = string.trim().toLowerCase();

        for (Choice choice : Choice.values()) {
            String choiceString = choice.toString().toLowerCase();
            if (choiceString.equals(cleanString)) {
                return Optional.of(choice);
            }
        }

        return Optional.empty();
    }

    private Choice randomChoice() {
        Integer choiceIndex = ThreadLocalRandom.current().nextInt(0, Choice.values().length);
        return Choice.values()[choiceIndex];
    }

    private void print(Outcome outcome) {
        System.out.println(toString(outcome));
    }

    private String toString(Outcome outcome) {
        switch (outcome) {
            case WIN:  return "You win!";
            case LOSE: return "You lose :(";
            case DRAW: return "It is a draw.";
        }
        throw new IllegalArgumentException();
    }
}
