import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortWordFilterTest {

    ShortWordFilter filter;
    String shortWord;
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