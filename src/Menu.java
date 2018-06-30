import java.util.Scanner;

public class Menu
{
    private Scanner input;

    Menu()
    {
        this.input = new Scanner(System.in);
    }

    // Prints the programs main menu
    public void printMainMenu()
    {

        boolean correctInput = true;

        while (correctInput)
        {
            System.out.println("Welcome to Hangman!\n" +
                               "Please select a category.\n");
            System.out.println("1: Animals");
            System.out.println("2: Curse Words");
            System.out.println("3: Countries");
            System.out.println("4: Food");
            System.out.println("5: Exit");
            System.out.println();

            Game game;
            String choice = input.next();

            // Process choice.
            switch (choice)
            {
                case "1":
                    game = new Game(FileHandler.getGameName((int)(Math.random()*25), "Animals.txt"));
                    runGame(game);
                    break;
                case "2":
                    game = new Game(FileHandler.getGameName((int)(Math.random()*25), "CurseWords.txt"));
                    runGame(game);
                    break;
                case "3":
                    game = new Game(FileHandler.getGameName((int)(Math.random()*25), "Countries.txt"));
                    runGame(game);
                    break;
                case "4":
                    game = new Game(FileHandler.getGameName((int)(Math.random()*25), "Food.txt"));
                    runGame(game);
                    break;
                case "5":
                    correctInput = false;
                    break;
            }
        }
    }

    private void runGame(Game game)
    {
        Prompter prompter = new Prompter(game);
        while (game.getRemainingTries() > 0 && !game.isWon())
        {
            prompter.currentProgress();
            prompter.promptForGuess();
        }
        game.displayOutcome();
    }
}
