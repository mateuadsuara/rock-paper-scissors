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

    private final Player first;
    private final Player second;
    private final Display display;

    public Game(Player first, Player second, Display display) {
        this.first = first;
        this.second = second;
        this.display = display;
    }

    public void play() {
        Choice firstChoice = first.choose();
        Choice secondChoice = second.choose();

        Outcome outcome = firstChoice.vs(secondChoice);

        display.printOutcome(firstChoice, secondChoice, outcome);
    }
}
