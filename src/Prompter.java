import  java.util.Scanner;

public class Prompter
{
    private Game game;
    private Scanner input = new Scanner(System.in);
    private boolean isAcceptable;

    // Constructor
    Prompter(Game game)
    {
        this.game = game;
    }

    // Prompts user for guess, calls game method to return hit or miss.
    public void promptForGuess()
    {
        do
        {
            System.out.print("Please enter a letter:  ");
            String guessInput = input.nextLine();

            try
            {
                game.applyGuess(guessInput);
                isAcceptable = true;
            }
            catch(IllegalArgumentException iae)
            {
                System.out.printf("%s Please try again. %n", iae.getMessage());
            }
        }
        while (!isAcceptable);
    }

    public void currentProgress()
    {
        System.out.printf("You have %d tries remaining to guess this word: %s%n",
                          game.getRemainingTries(), game.getCurrentProgress());
    }
}