import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Implements the ShortWordFilter Object to filter a given text file and output any words less than 5 characters long.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ShortLister
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This file chooser is used to select a file to read
        JFileChooser chooser = new JFileChooser();

        //This File holds the file selected by the user
        File selectedFile;

        //This Object contains a method for accepting or rejecting words based on their length
        ShortWordFilter filter = new ShortWordFilter();

        //This String holds the line that has just been read from the selected file
        String rec = "";

        //This ArrayList holds all the lines that have been read from the selected file
        ArrayList<String> lines = new ArrayList<>();

        //This array holds all the words from the file after they have been split up
        String[] fields;

        //This algorithm reads the file selected by the user and tries to catch exceptions
        try
        {
            System.out.println("Please select a file to be filtered for short words.");

            //This File holds the current directory
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            //This algorithm tests whether the user has selected a file and either closes the program or sets up a file reader depending on the result
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                //This algorithm reads each line from the chosen file into a String and adds that String to the lines ArrayList
                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                }
                reader.close();
                System.out.println("\n\nThe data file has been read.\n");

                System.out.println("Short words from the file:");
                System.out.println("==========================");

                //This algorithm splits each line from the file into individual words, then filters those words by length and prints words below 5 characters to the console
                for(String l : lines)
                {
                    //This int tracks the current index for the fields array as it is looped through
                    int fieldsIndex = 0;

                    //This boolean tracks whether each word is longer or shorter than 5 characters and stores a true/false value
                    boolean shortWord = false;
                    fields = l.split(" ");

                    //This algorithm checks if each word in the fields array is longer or shorter than 5 characters and prints the words below 5 characters long
                    for(String f : fields)
                    {
                        shortWord = filter.accept(fields[fieldsIndex].replaceAll("[.,;?:!()/]", ""));

                        //This algorithm checks that a word is below 5 characters and prints it to the console
                        if(shortWord)
                        {
                            System.out.println(fields[fieldsIndex].replaceAll("[.,;?:!()/]", ""));
                        }

                        fieldsIndex++;
                    }
                }
            }
            else
            {
                System.out.println("No file was selected.");
                System.out.println("Please run the program again to select a file.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file couldn't be found.");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("An exception occurred.");
            e.printStackTrace();
        }
    }
}