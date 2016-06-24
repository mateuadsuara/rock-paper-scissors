import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        new Game(System.in, System.out, ThreadLocalRandom.current()).play();
    }
}
