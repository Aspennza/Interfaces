import java.awt.*;

/**
 * Allows the creation of BigRectangleFilter Objects that come with a method for checking if
 * a Rectangle has a perimeter above or below 10. Returns a true/false value based on perimeter size.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class BigRectangleFilter implements Filter
{
    /**
     * Takes a Rectangle as input and determines whether its perimeter is above or below 10.
     * @param x An Object (presumably a Rectangle) whose perimeter will be evaluated.
     * @return  A true/false value based on whether the Rectangle's perimeter is above or below 10.
     */
    @Override
    public boolean accept(Object x)
    {
        boolean ret = false;
        double rectPerim = 0;
        Rectangle r = (Rectangle) x;

        rectPerim = (r.getHeight() * 2) + (r.getWidth() * 2);

        if (rectPerim > 10)
        {
            ret = true;
        }

        return ret;
    }
}
