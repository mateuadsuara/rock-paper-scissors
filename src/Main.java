import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        new Game(
                new HumanPlayer(System.in, System.out),
                new ComputerPlayer(ThreadLocalRandom.current()),
                new Display(System.out)
        ).play();
    }
}
