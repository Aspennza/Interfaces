import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

//Tasks:
//check prof. wulf's second recording on thursday for reference on ShortLister and BigRectLister
//Create UML diagrams
//Create JUnit tests? it doesn't seem like they're required??
//Write javadoc

public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();

        File selectedFile;

        ShortWordFilter filter = new ShortWordFilter();

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
                    int fieldsIndex = 0;
                    boolean shortWord = false;
                    fields = l.split(" ");

                    for(String f : fields)
                    {
                        shortWord = filter.accept(fields[fieldsIndex].replaceAll("[.,;?:!()/]", ""));

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