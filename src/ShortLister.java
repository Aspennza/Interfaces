import java.io.FileNotFoundException;
import java.io.IOException;

public class ShortLister
{
    public static void main(String[] args)
    {

        try
        {

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