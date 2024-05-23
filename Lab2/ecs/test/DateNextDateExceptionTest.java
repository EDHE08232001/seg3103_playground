import static org.junit.Assert.assertThrows;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterized test case for verifying Date exception handling.
 */
@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {
    private int year;
    private int month;
    private int day;
    private Class<? extends Throwable> expectedException;
    private String message;

    public DateNextDateExceptionTest(int year, int month, int day, Class<? extends Throwable> expectedException,
            String message) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.expectedException = expectedException;
        this.message = message;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2020, 2, 30, IllegalArgumentException.class,
                        "Should throw exception for invalid day in February on a non-leap year" },
                { -1, 1, 1, IllegalArgumentException.class, "Should throw exception for negative year values" },
                { 2020, 13, 1, IllegalArgumentException.class,
                        "Should throw exception for month values outside valid range (1-12)" },
                { 2021, 2, 29, IllegalArgumentException.class,
                        "Should throw exception for February 29 in a non-leap year" },
                { 2020, 1, -1, IllegalArgumentException.class, "Should throw exception for negative day values" },
                { 2020, 4, 31, IllegalArgumentException.class,
                        "Should throw exception for April 31st, which does not exist" }
        });
    }

    @Test
    public void testDateValidation() {
        assertThrows(message, expectedException, () -> new Date(year, month, day).nextDate());
    }
}
