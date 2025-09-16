import java.awt.Rectangle;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        boolean ret = false;
        int rectPerim = 0;
        Rectangle r = (Rectangle) x;

        rectPerim = (r.height * 2) + (r.width * 2);

        if (rectPerim > 10)
        {
            ret = true;
        }

        return ret;
    }
}
