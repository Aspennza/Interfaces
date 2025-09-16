import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BigRectangleFilterTest {

    Rectangle rect1;
    Rectangle rect2;
    BigRectangleFilter filter;

    @BeforeEach
    void setUp()
    {
        filter = new BigRectangleFilter();
        rect1 = new Rectangle(1, 2);
        rect2 = new Rectangle(5, 6);
    }

    @Test
    void accept()
    {
        assertFalse(filter.accept(rect1));
        assertTrue(filter.accept(rect2));
    }
}