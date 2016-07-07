import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class HumanPlayer {
    private Scanner scanner;
    private PrintStream output;

    public HumanPlayer(InputStream input, PrintStream output) {
        this.scanner = new Scanner(input);
        this.output = output;
    }

    public Game.Choice choose() {
        List<Game.Choice> options = Arrays.asList(Game.Choice.values());
        output.println("Choose: " + options);

        Game.Choice choice;
        while ((choice = choiceFrom(options)) == null) {
            output.println("Invalid choice.");
        }

        return choice;
    }

    private Game.Choice choiceFrom(List<Game.Choice> options) {
        String userInput = scanner.nextLine();

        for (Game.Choice choice : options) {
            if (choice.toString().equals(userInput))
                return choice;
        }

        return null;
    }

}
