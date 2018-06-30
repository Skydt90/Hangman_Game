import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler
{
    // Reads the names from a file and returns a String[] with the names.
    private static String[] readInfoFromFile(String path)
    {
        File file = new File(path);
        String[] gameNames = new String[25];     //List to return.
        int size = 0;

        try
        {
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine())
            {
                String[] temp;                      //Temporary storage array.
                String str = reader.nextLine();
                temp = str.split(",");

                for (String name : temp)
                {
                    gameNames[size] = name;
                    size++;
                }
            }
            reader.close();
        }
        catch (FileNotFoundException FNF)
        {
            FNF.printStackTrace();
        }
        return gameNames;
    }

    // Returns a name from the name[] based off index.
    public static String getGameName(int n, String filePath)
    {
        String[] namesFromList = readInfoFromFile(filePath);
        return namesFromList[n];
    }
}


