import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the ShortWordFilter class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class ShortWordFilterTest {

    //An instance of ShortWordFilter.
    ShortWordFilter filter;

    //A String for testing the ShortWordFilter.
    String shortWord;

    //A String for testing the ShortWordFilter.
    String longWord;

    @BeforeEach
    void setUp()
    {
        filter = new ShortWordFilter();
        shortWord = "is";
        longWord = "anemone";
    }

    @Test
    void accept()
    {
        assertTrue(filter.accept(shortWord));
        assertFalse(filter.accept(longWord));
    }
}