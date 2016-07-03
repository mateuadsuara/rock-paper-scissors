public class DisplaySpy extends Display {
    class Call {
        final Game.Choice first;
        final Game.Choice second;
        final Game.Outcome outcome;

        public Call(Game.Choice first, Game.Choice second, Game.Outcome outcome) {
            this.first = first;
            this.second = second;
            this.outcome = outcome;
        }
    }

    Call lastCall = null;

    public DisplaySpy() {
        super(null);
    }

    public void printOutcome(Game.Choice first, Game.Choice second, Game.Outcome outcome) {
        lastCall = new Call(first, second, outcome);
    }
}
