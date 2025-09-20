import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Randomly generates Rectangle Objects, determines whether their perimeters are above or below 10, and outputs any Rectangles with perimeters above 10.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class BigRectLister
{
    //This int sets the total number of Rectangles to be generated
    static final int TOTAL_RECTANGLES = 10;

    //This Random object allows for random generation of height and width parameters
    static Random gen = new Random();

    //This ArrayList stores all the Rectangles created
    static ArrayList<Rectangle> rectangles = new ArrayList<>();

    //This BigRectangleFilter allows the Rectangles to be tested for perimeters above or below 10
    static BigRectangleFilter filter;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This int counts how many Rectangles have perimeters above 10
        int counter = 0;
        createDataSet();

        //This BigRectangleFilter allows the Rectangles to be tested for perimeters above or below 10
        filter = new BigRectangleFilter();

        System.out.println("Rectangle Number          Height Width  Perimeter");
        System.out.println("=================================================");

        //This algorithm loops through all the Rectangles in the rectangles ArrayList, checks if they have perimeters above or below 10, and prints those above 10
        for(Rectangle rec : rectangles)
        {
            //This algorithm tests if each Rectangle in the rectangles ArrayList has a perimeter above or below 10 and prints the data from those above 10
            if(filter.accept(rec))
            {
                counter++;
                System.out.printf("Rectangle #%3d accepted: %5.2f\t%5.2f\t%5.2f\n", counter, rec.getHeight(), rec.getWidth(), 2 * rec.getHeight() + 2 * rec.getWidth());
            }
        }
        System.out.println("\n" + counter + " accepted out of " + rectangles.size());
    }

    /**
     * This method uses randomly generated numbers to create a dataset of 10 Rectangle Objects.
     */
    private static void createDataSet()
    {
        int height = 0;
        int width = 0;

        for(int r = 0; r < TOTAL_RECTANGLES; r++)
        {
            height = gen.nextInt(4) + 1;
            width = gen.nextInt(4) + 1;
            rectangles.add(new Rectangle(width, height));
        }
    }
}
