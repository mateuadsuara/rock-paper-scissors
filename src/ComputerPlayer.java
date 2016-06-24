import java.util.Random;

class ComputerPlayer implements Player {
    private Random random;

    public ComputerPlayer(Random random) {
        this.random = random;
    }

    @Override
    public Game.Choice choose() {
        Integer choiceIndex = random.nextInt(Game.Choice.values().length);
        return Game.Choice.values()[choiceIndex];
    }
}
