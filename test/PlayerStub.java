public class PlayerStub implements Player {
    private Game.Choice choice;

    public PlayerStub(Game.Choice choice) {
        this.choice = choice;
    }

    @Override
    public Game.Choice choose() {
        return choice;
    }
}
