import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

//Tasks:
//Create UML diagrams
//Write javadoc

public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();

        File selectedFile;

        String rec = "";

        ArrayList<String> lines = new ArrayList<>();

        String[] fields;


        try
        {
            System.out.println("Please select a file to be filtered for short words.");

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                }
                reader.close();
                System.out.println("\n\nThe data file has been read.\n");

                System.out.println("Short words from the file:");
                System.out.println("==========================");

                for(String l : lines)
                {
                    fields = l.split(" ");
                }
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