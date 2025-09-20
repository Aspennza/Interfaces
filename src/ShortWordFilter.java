/**
 * Allows the creation of ShortWordFilter objects that come with a method for checking
 * the length of a String and returning a true or false value based on its length.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ShortWordFilter implements Filter
{
    /**
     * Returns a true or false value after judging whether a String input is above or below 5 characters.
     * @param x The Object (presumably a String) whose length will be tested.
     * @return  A boolean representing whether the String is above or below 5 characters.
     */
    @Override
    public boolean accept(Object x)
    {
        String s = (String) x;
        boolean ret = false;

        if(s.length() < 5)
        {
            ret = true;
        }

        return ret;
    }
}
