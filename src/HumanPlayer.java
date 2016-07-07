import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class HumanPlayer {
    public static Game.Choice choose(InputStream input, PrintStream output) {
        Scanner scanner = new Scanner(input);

        List<Game.Choice> options = Arrays.asList(Game.Choice.values());
        output.println("Choose: " + options);

        Game.Choice choice;
        while ((choice = choiceFrom(scanner, options)) == null) {
            output.println("Invalid choice.");
        }

        return choice;
    }

    private static Game.Choice choiceFrom(Scanner scanner, List<Game.Choice> options) {
        String userInput = scanner.nextLine();

        for (Game.Choice choice : options) {
            if (choice.toString().equals(userInput))
                return choice;
        }

        return null;
    }
}
