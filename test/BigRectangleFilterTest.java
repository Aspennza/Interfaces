import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the basic functionality of the methods in the BigRectangleFilter class.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
class BigRectangleFilterTest {

    //A Rectangle object for testing the functions.
    Rectangle rect1;

    //A Rectangle object for testing the functions.
    Rectangle rect2;

    //An instance of BigRectangleFilter.
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