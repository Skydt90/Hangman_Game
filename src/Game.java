public class Game
{
    private String answer;
    private String hits;
    private String misses;

    // Constructor
    Game(String answer)
    {
        this.answer = answer.toUpperCase();
        hits = "";
        misses = "";
    }

    // Ensures input is a letter and converts to lowercase.
    private char normalizeGuess(char letter)
    {
        if (!Character.isLetter(letter))
        {
            throw new IllegalArgumentException("A letter is required!");
        }
        letter = Character.toUpperCase(letter);

        //Exception for letters already guessed.
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1)
        {
            throw new IllegalArgumentException("the letter " + letter + " has already been guessed.");
        }
        return letter;
    }

    public void applyGuess(String letters)
    {
        if (letters.length() == 0)
        {
            throw new IllegalArgumentException("No letter was entered.");
        }
        applyGuess(letters.charAt(0));
    }

    // Method for guessing a letter.
    private void applyGuess(char letter)
    {
        letter = normalizeGuess(letter);          //Calls the normalization method.
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit)
        {
            hits += letter;
        }
        else
        {
            misses += letter;
        }
    }

    public int getRemainingTries()
    {
        final int MAX_MISSES = 7;
        return MAX_MISSES - misses.length();
    }

    // Displaying current progress via enhanced for loop.
    public String getCurrentProgress()
    {
        String progress = "";

        for (char letter : answer.toCharArray())
        {
            char display = '-';
            if (hits.indexOf(letter) != -1)
            {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon()
    {
        return getCurrentProgress().indexOf('-') == -1;
    }

    public void displayOutcome()
    {
        if (isWon())
        {
            System.out.printf("\nThe word was: %s. \nCongratulations," +
                              " you've won the game with %d tries left!\n\n", answer.toUpperCase(), getRemainingTries());
        }
        else
        {
            System.out.printf("\nToo bad, you've lost the game. The word was: %s\n\n", answer.toUpperCase());
        }
    }
}
