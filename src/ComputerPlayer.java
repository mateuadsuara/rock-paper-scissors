import java.util.Random;

class ComputerPlayer {
    public static Game.Choice choose(Random random) {
        Integer choiceIndex = random.nextInt(Game.Choice.values().length);
        return Game.Choice.values()[choiceIndex];
    }
}
