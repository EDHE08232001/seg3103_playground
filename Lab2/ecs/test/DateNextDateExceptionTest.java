import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DateNextDateExceptionTest {

    // Test to verify that an exception is thrown for invalid day values
    @Test
    void testInvalidDay() {
        // Should throw an IllegalArgumentException for a day value that exceeds the
        // month's max days
        assertThrows(IllegalArgumentException.class,
                () -> new Date(2020, 2, 30).nextDate(),
                "Should throw exception for invalid day in February on a non-leap year");
    }

    // Test to verify that an exception is thrown for negative year values
    @Test
    void testNegativeYear() {
        // Should throw an IllegalArgumentException for negative year values
        assertThrows(IllegalArgumentException.class,
                () -> new Date(-1, 1, 1).nextDate(),
                "Should throw exception for negative year values");
    }

    // Test to verify that an exception is thrown for invalid month values
    @Test
    void testInvalidMonth() {
        // Should throw an IllegalArgumentException for month values outside 1-12
        assertThrows(IllegalArgumentException.class,
                () -> new Date(2020, 13, 1).nextDate(),
                "Should throw exception for month values outside valid range (1-12)");
    }

    // Test to verify that an exception is thrown for a leap day in a non-leap year
    @Test
    void testLeapDayInNonLeapYear() {
        // Should throw an IllegalArgumentException for February 29 in a non-leap year
        assertThrows(IllegalArgumentException.class,
                () -> new Date(2021, 2, 29).nextDate(),
                "Should throw exception for February 29 in a non-leap year");
    }

    // Test to verify that an exception is thrown for invalid negative day values
    @Test
    void testNegativeDay() {
        // Should throw an IllegalArgumentException for negative day values
        assertThrows(IllegalArgumentException.class,
                () -> new Date(2020, 1, -1).nextDate(),
                "Should throw exception for negative day values");
    }

    // Test to verify that an exception is thrown for invalid day values at the edge
    // of validity
    @Test
    void testExcessiveDay() {
        // Should throw an IllegalArgumentException for day values that are too high,
        // even if technically within typical limits
        assertThrows(IllegalArgumentException.class,
                () -> new Date(2020, 4, 31).nextDate(),
                "Should throw exception for April 31st, which does not exist");
    }
}
