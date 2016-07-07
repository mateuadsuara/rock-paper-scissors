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

    public static Outcome play(Choice firstChoice, Choice secondChoice) {
        return firstChoice.vs(secondChoice);
    }
}
