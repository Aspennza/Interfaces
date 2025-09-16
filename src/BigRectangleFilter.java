import java.awt.*;

public class BigRectangleFilter implements Filter
{
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
