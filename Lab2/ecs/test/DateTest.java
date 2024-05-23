import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterized test class for Date class to handle various date transition
 * scenarios and validate exception handling for invalid inputs.
 */
@RunWith(Parameterized.class)
class DateTest {
    private Date inputDate;
    private Date expectedDate;
    private Class<? extends Throwable> expectedException;
    private String message;

    // Constructor for parameters
    public DateTest(Date inputDate, Date expectedDate, Class<? extends Throwable> expectedException, String message) {
        this.inputDate = inputDate;
        this.expectedDate = expectedDate;
        this.expectedException = expectedException;
        this.message = message;
    }

    // Parameter method for various date scenarios
    @Parameters(name = "{index}: Test with {0} expecting {1} or {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Date(2020, 5, 3), new Date(2020, 5, 4), null,
                        "Should return the next day correctly within the same month" },
                { new Date(1700, 6, 20), new Date(1700, 6, 21), null,
                        "Next day in June should be calculated correctly" },
                { new Date(2005, 4, 15), new Date(2005, 4, 16), null,
                        "Next day in April should be calculated correctly" },
                { new Date(444, 2, 28), new Date(444, 3, 1), null,
                        "Transition from leap day should handle leap year correctly" },
                { new Date(2001, 2, 28), new Date(2001, 3, 1), null,
                        "End of February in a non-leap year should transition to March" },
                { new Date(1500, 2, 31), null, IllegalArgumentException.class,
                        "Invalid day in February should throw IllegalArgumentException" },
                { new Date(1500, 2, 29), null, IllegalArgumentException.class,
                        "Non-leap year should not allow February 29 and throw IllegalArgumentException" },
                { new Date(-1, 10, 20), null, IllegalArgumentException.class,
                        "Negative year values should throw IllegalArgumentException" },
                { new Date(1975, 6, -50), null, IllegalArgumentException.class,
                        "Negative day values should throw IllegalArgumentException" }
        });
    }

    // The test method that applies both positive and exception cases
    @Test
    public void testDateTransitionsAndValidations() {
        if (expectedException == null) {
            assertEquals(expectedDate, inputDate.nextDate(), message);
        } else {
            assertThrows(expectedException, () -> inputDate.nextDate(), message);
        }
    }
}
