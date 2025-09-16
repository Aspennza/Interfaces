import java.awt.*;
import java.util.ArrayList;
import java.util.Random;



public class BigRectLister
{
    static final int TOTAL_RECTANGLES = 10;
    static Random gen = new Random();
    static ArrayList<Rectangle> rectangles = new ArrayList<>();
    static BigRectangleFilter filter;

    public static void main(String[] args)
    {
        int counter = 0;
        createDataSet();

        filter = new BigRectangleFilter();

        for(Rectangle rec : rectangles)
        {
            if(filter.accept(rec))
            {
                counter++;
                System.out.printf("Rectangle #%3d accepted: %5.2f\t%5.2f\t%5.2f\n", counter, rec.getHeight(), rec.getWidth(), 2 * rec.getHeight() + 2 * rec.getWidth());
            }
        }
        System.out.println("\n" + counter + " accepted out of " + rectangles.size());
    }

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
