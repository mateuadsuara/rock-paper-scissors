import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class HumanPlayer implements Player {
    private InputStream input;
    private PrintStream output;

    public HumanPlayer(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public Game.Choice choose() {
        List<Game.Choice> options = Arrays.asList(Game.Choice.values());
        output.println("Choose: " + options);

        Game.Choice choice = choiceFrom(options);

        while (choice == null) {
            output.println("Invalid choice.");
            choice = choiceFrom(options);
        }

        return choice;
    }

    private Game.Choice choiceFrom(List<Game.Choice> options) {
        String userInput = new Scanner(input).nextLine();

        for (Game.Choice choice : options) {
            if (choice.toString().equals(userInput))
                return choice;
        }

        return null;
    }

}
